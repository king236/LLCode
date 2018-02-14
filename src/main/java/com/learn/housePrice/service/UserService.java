package com.learn.housePrice.service;


import com.learn.housePrice.entity.User;

import java.util.List;

public interface UserService extends IBaseService<User, Long>{
	/*
	 * 用户关联角色
	 * @params userId,roleIds
	 * @return
	 */
	public void grantUserRoles(Long id, Long [] roleIds);
	/*
	 * 检查用户是否可以登录
	 * @params user
	 * @return user
	 */
	public User checkUserLogin(User user);
	/*
	 * 删除角色
	 * @params userId
	 * @return
	 */
	//public void deleteRoleByUserId(Long userId);
	/*
	 * 获取用户的角色Id列表
	 * @params userId
	 * @return List<Long>
	 */
	public List<Long> getRolesIdsByUserId(Long userId);

	/**
	 * 通过用户名查找用户
	 * @param userName
	 * @return User
	 */
	public User findUserByName(String userName);
}
