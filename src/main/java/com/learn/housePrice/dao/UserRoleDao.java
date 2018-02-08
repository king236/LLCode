package com.learn.housePrice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRoleDao{

	/*
	 * 用户关联角色
	 * @params userId,roleIds
	 * @return
	 */
	public void grantUserRoles(@Param("userId") Long userId, @Param("roleIds") Long [] roleIds);
	/*
	 * 删除角色
	 * @params userId
	 * @return
	 */
	public void deleteRoleByUserId(Long userId);
	/*
	 * 删除角色
	 * @params roleId
	 * @return
	 */
	public void deleteRoleByRoleId(Long roleId);
	
	/*
	 * 获取用户的角色Id列表
	 * @params userId
	 * @return List<Long>
	 */
	public List<Long> getRolesIdsByUserId(Long userId);
}
