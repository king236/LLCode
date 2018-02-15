package com.learn.housePrice.common.realm;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShiroCommonRealm extends AuthorizingRealm {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("userRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.debug("in authenticationInfo");
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findUserByName(username);
        if (user == null){
            log.error("用户 { " + username + " } 不存在 ");
            throw new AccountException("账户不存在");
        }
        if(user.getStatus() == "2"){
            log.error("用户 { " + username + " } 被禁止登录 ");
            throw new DisabledAccountException("账号已经禁止登录");
        }else{
            user.setLastLoginTime(new Date());
            userService.update(user);
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPswd(),
                getName()
        );

        return authenticationInfo;
    }
}
