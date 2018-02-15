package com.learn.housePrice.controller;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {

	@Autowired
	UserService userService;

	private static final Logger log = LoggerFactory.getLogger("MainLogger");

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index(){
        return "/admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
	public String welcome(){
		return "admin/welcome";
	}
    
    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    public ModelAndView login(){
    	ModelAndView modelAndView = new ModelAndView("/admin/login");
        return modelAndView;
    }
    
    @RequestMapping(value="/admin/login", method = RequestMethod.POST)
    public String doLogin(Model model, User user, HttpSession session){
    	/*model.addAttribute("userInfo", userDao.getUser(user));
    	Result result = new Result();*/
    	User userCheck = userService.checkUserLogin(user);
    	if (userCheck != null) {
			session.setAttribute("userInfo", userCheck);
			return "redirect:/admin/index";
			//result.setResult("success");
		} else {
			session.removeAttribute("userInfo");
			model.addAttribute("message", "登录失败，用户名或者密码错误。");
			return "/admin/login";
		}
    }

    @RequestMapping(value = "/admin/loginByShiro", method = RequestMethod.GET)
	public String loginByShiro(){
    	System.out.println("In login");
		return "/admin/login";
	}

    @RequestMapping(value = "/admin/loginByShiro", method = RequestMethod.POST)
	public String loginByShiro(User user, HttpServletRequest request, Map<String, Object> map) throws Exception{

		System.out.println("In loginByShiro");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> "+exception;
				System.out.println("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		// 此方法不处理登录成功,由shiro进行处理
    	return loginByShiro();
	}
}
