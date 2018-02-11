package com.learn.housePrice.controller;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    	//model.addAttribute("userInfo", userDao.getUser(user));
    	//Result result = new Result();
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

    @RequestMapping(value = "/admin/loginByShiro", method = RequestMethod.POST)
	@ResponseBody
	public String loginByShiro(){
    	log.error("run times");
    	return "/admin/login";
	}
}
