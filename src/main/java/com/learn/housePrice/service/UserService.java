package com.learn.housePrice.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.learn.housePrice.entity.User;

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
	
}
