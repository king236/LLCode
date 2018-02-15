package com.learn.housePrice.web.fliter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 登录验证成功之后，会直接跳转到之前的访问地址
 * 在系统中，如果以前的地址错误，也不能很好的跳转
 * 所以先考虑以前的地址，在后面考虑验证地址正确再进行合理的地址跳转
 */
public class CommonFormAuthenticationFilter extends FormAuthenticationFilter {
    /**
     * 重写onLoginSuccess方法实现登录验证后返回首页
     * @param
     * @return boolean
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("In override onLoginSuccess");
        //清空会话SESSION中保留的请求地址
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.issueRedirect(request, response, getSuccessUrl());
        //return super.onLoginSuccess(token, subject, request, response);
        return false;
    }
}
