package com.learn.housePrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.housePrice.entity.UserEntity;
import com.learn.housePrice.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getUsers")
	public List<UserEntity> getUser(){
		return userMapper.getAll();				
	}
	
	@RequestMapping("/getUser")
	public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }    
	
	@RequestMapping(value="del/{id}")
	public void del(@PathVariable("id") Long id){
		userMapper.delete(id);
	}
}
