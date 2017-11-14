package com.learn.housePrice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void update(User user){
		userMapper.update(user);
	}
	
	

}
