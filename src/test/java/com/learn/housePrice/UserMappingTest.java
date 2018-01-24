package com.learn.housePrice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.housePrice.dao.PermissionDao;
import com.learn.housePrice.dao.RoleDao;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.entity.Role;
import com.learn.housePrice.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMappingTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());  
	@Test
	public void testRoleInsert() throws Exception {
		Role role = new Role();
		role.setName("test");
		role.setRoleKey("test");
		role.setStatus("0");
		
		roleDao.insert(role);
		
		log.debug("insert success id=" + role.getId());
	}
	/*@Test
	public void testInsert() throws Exception {
		
		
			User user =  new User();
			user.setNickname("test" + 13);
			user.setPswd("testPSWD" + 13);
			user.setEmail("testEMAIL" + 13);
			user.setStatus("0");
			user.setCreateTime(new Date());
			Long insetNum = userDao.insert(user);
			
			log.debug("insert u_user num = " + insetNum + " ,id = " + user.getId());

	}*/

/*	@Test
	public void testQuery() throws Exception {
		List<User> users = userDao.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		User user = userDao.getOne(2L);
		System.out.println(user.toString());
		user.setNickname("neo");
		userDao.update(user);
		Assert.assertTrue(("neo".equals(userDao.getOne(2L).getNickname())));
	}*/
	
	/*@Test
	public void selectByMap() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("nickname", "test13");
		params.put("pswd", "testPSWD13");
		List<User> userList = userDao.selectByMap(params);
		log.info("userList = " + userList.toString());
		if(userList != null && userList.size() > 0){
			params.put("id", userList.get(0).getId());
			List<Role> roleList = roleDao.selectByMap(params);
			log.info("roleList = " + roleList.toString());
			List<Permission> permissionList = permissionDao.selectByMap(params);
			log.info("permissionList = " + permissionList.toString());
		}
	}*/
}
