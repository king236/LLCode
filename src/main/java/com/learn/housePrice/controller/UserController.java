package com.learn.housePrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getUsers")
	public List<User> getUser(){
		return userMapper.getAll();				
	}
	
	@RequestMapping("/getUser")
	public User getUser(Long id) {
    	User user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(User user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(User user) {
    	userMapper.update(user);
    }    
	
	@RequestMapping(value="del/{id}")
	public void del(@PathVariable("id") Long id){
		userMapper.delete(id);
	}
}
