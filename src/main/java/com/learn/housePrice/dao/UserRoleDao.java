package com.learn.housePrice.dao;

import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {

	public void grantUserRoles(@Param("userId") Long userId, @Param("roleIds") Long [] roleIds);
	
	public void deleteRoleByUserId(Long userId);
	
	public void deleteRoleByRoleId(Long roleId);
}
