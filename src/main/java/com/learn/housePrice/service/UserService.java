package com.learn.housePrice.service;

import org.springframework.stereotype.Component;

import com.learn.housePrice.entity.User;

public interface UserService{
	
	public void saveOrUpdate(User user);
	
	public void grantUserRoles(Long id, Long [] roleIds);
}
