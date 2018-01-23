package com.learn.housePrice.service;

import org.springframework.stereotype.Service;

import com.learn.housePrice.entity.User;

@Service
public interface UserService {
	
	public  void saveOrUpdate(User user);
	
}
