package com.learn.housePrice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.entiy.LearnResouce;
import com.learn.housePrice.util.Result;

@Controller
@RequestMapping(value = "/admin")
public class HelloWorldController {

	@Autowired
	UserDao userDao;
	
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/admin/index";
    }

    @RequestMapping(value = {"/welcome"})
	public String welcome(){
		return "admin/welcome";
	}
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(){
    	ModelAndView modelAndView = new ModelAndView("/admin/login");
        return modelAndView;
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)   
    public String doLogin(Model model, User user, HttpSession session){
    	//model.addAttribute("userInfo", userDao.getUser(user));
    	//Result result = new Result();
    	User userCheck = userDao.getUser(user);
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
}
