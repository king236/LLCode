package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.Role;

public interface RoleDao extends BaseDao<Role>{

	public List<Role> selectByMap(Map<String, Object> map);
	
	public List<Role> findRolesByUserId(Long userId);

}
