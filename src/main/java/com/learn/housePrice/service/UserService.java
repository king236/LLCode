package com.learn.housePrice.service;


import com.learn.housePrice.entity.User;

public interface UserService extends IBaseService<User, Long>{
	
	public static final String REPOSITORY_NAME = "siteInvitationAddressDao";
	
	public void saveOrUpdate(User user);
	
	public void grantUserRoles(Long id, Long [] roleIds);
	
	public User checkUserLogin(User user);
}
