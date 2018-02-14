package com.learn.housePrice.common.realm;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShirioRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("in authenticationInfo");
        String username = (String) token.getPrincipal();
        System.out.println("credentials = " + token.getCredentials());
        User user = userService.findUserByName(username);
        if (user == null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getNickname(),
                user.getPswd(),
                getName()
        );

        return authenticationInfo;
    }
}
