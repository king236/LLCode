package com.learn.housePrice.service;

import java.util.List;

import com.learn.housePrice.entity.Role;

public interface RoleService extends IBaseService<Role, Long>{
	
	/*
	 * 获取用户角色
	 * @params userId
	 * @return List<Role>
	 */
	public List<Role> findRolesByUserId(Long userId);
	
}
