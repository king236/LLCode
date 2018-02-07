package com.learn.housePrice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RolePermissionDao {

	public void grantRolePermissions(@Param("roleId") Long roleId, @Param("permissionIds") Long [] permissionIds);
	
	public void deletePermissionByPermissionId(Long permissionId);
	
	public void deletePermissionByRoleId(Long roleId);
	
	public List<Long> findPermissionsByRoleId(Long roleId);
}
