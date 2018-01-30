package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.Menu;
import com.learn.housePrice.entity.Permission;

public interface PermissionDao extends BaseDao<Permission>{

	public List<Permission> selectByMap(Map<String, Object> map);
	
	Long getSortMax(Permission permission);
	
	List<Permission> getPermissionChild(Map<String,Object> params);
	
	List<Permission> getPermissionParent();
	
	public List<Long> findPermissionsByRoleId(Long roleId);
}
