package com.learn.housePrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userMapper;
	
	@RequestMapping("/user")
	public String index(){
		return "/user/user2";
	}
	
	@RequestMapping(value="/user/getUserList", method=RequestMethod.GET)
	@ResponseBody
	public List<User> getUserList(){
		return userMapper.getAll();
	}
}
