package com.learn.housePrice.service;

import com.learn.housePrice.entity.User;

public interface UserService {
	
	public void saveOrUpdate(User user);
	
	public void delete(Long userId);
	
	public void grantUserRoles(Long id, Long [] roleIds);
}
