package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.Role;

public interface RoleDao extends BaseDao<Role, Long>{
	/*
	 * 获取用户角色
	 * @params userId
	 * @return List<Role>
	 */
	public List<Role> findRolesByUserId(Long userId);

}
