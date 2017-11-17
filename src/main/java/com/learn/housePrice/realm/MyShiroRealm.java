package com.learn.housePrice.realm;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.learn.housePrice.dao.PermissionDao;
import com.learn.housePrice.dao.RoleDao;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.entity.Role;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.util.DESUtil;

@Component
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RoleDao roleDao;
	
	//用户登录次数计数  redisKey 前缀
	private String SHIRO_LOGIN_COUNT = "shiro_login_count_";
	
	//用户登录是否被锁定    一小时 redisKey 前缀
	private String SHIRO_IS_LOCK = "shiro_is_lock_";


	/*
	 * 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String name = token.getUsername();
		String password = String.valueOf(token.getPassword());
		//访问一次，计数一次
		ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
		opsForValue.increment(SHIRO_LOGIN_COUNT+name, 1);
		//计数大于5时，设置用户被锁定一小时
		if(Integer.parseInt(opsForValue.get(SHIRO_LOGIN_COUNT+name))>=5){
			opsForValue.set(SHIRO_IS_LOCK+name, "LOCK");
			stringRedisTemplate.expire(SHIRO_IS_LOCK+name, 1, TimeUnit.HOURS);
		}
		if ("LOCK".equals(opsForValue.get(SHIRO_IS_LOCK+name))){
			throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", name);
		//密码进行加密处理  明文为  password+name
		String paw = password+name;
		String pawDES = DESUtil.encryptBasedDes(paw);
		map.put("pswd", pawDES);
		User user = null;
		// 从数据库获取对应用户名密码的用户
		List<User> userList = userDao.selectByMap(map);
		if(userList.size()!=0){
			user = userList.get(0);
		} 
		if (null == user) {
			throw new AccountException("帐号或密码不正确！");
		}else if("0".equals(user.getStatus())){
			/**
			 * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
			 */
			throw new DisabledAccountException("此帐号已经设置为禁止登录！");
		}else{
			//登录成功
			//更新登录时间 last login time
			user.setLastLoginTime(new Date());
			userDao.update(user);
			//清空登录计数
			opsForValue.set(SHIRO_LOGIN_COUNT+name, "0");
		}
		//Logger.getLogger(getClass()).info("身份认证成功，登录用户："+name);
		return new SimpleAuthenticationInfo(user, password, getName());
	}
	
	 /*
	  * 授权
	  */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		Long userId = user.getId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		//根据用户ID查询角色（role），放入到Authorization里。
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", userId);
		List<Role> roleList = roleDao.selectByMap(map);
		Set<String> roleSet = new HashSet<String>();
		for(Role role : roleList){
			roleSet.add(role.getType());
		}
		roleSet.add("100002");//测试数据
		info.setRoles(roleSet);
		//根据用户ID查询权限（permission），放入到Authorization里。
		List<Permission> permissionList = permissionDao.selectByMap(map);
		Set<String> permissionSet = new HashSet<String>();
		for(Permission Permission : permissionList){
			permissionSet.add(Permission.getName());
		}
		
		permissionSet.add("权限添加");//测试数据
		permissionSet.add("权限删除");//测试数据
		info.setStringPermissions(permissionSet);
        return info;
	}
	
}