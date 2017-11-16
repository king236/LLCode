package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.Permission;

public interface PermissionDao {

	public List<Permission> selectByMap(Map<String, Object> map);
	
}
