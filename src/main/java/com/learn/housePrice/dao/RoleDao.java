package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.Role;

public interface RoleDao {

	public List<Role> selectByMap(Map<String, Object> map);
	
}
