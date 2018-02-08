package com.learn.housePrice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RolePermissionDao {
	/*
	 * 角色关联权限
	 * @params roleId,permissionIds
	 * @return
	 */
	public void grantRolePermissions(@Param("roleId") Long roleId, @Param("permissionIds") Long [] permissionIds);
	/*
	 * 删除权限
	 * @params permissionId
	 * @return
	 */
	public void deletePermissionByPermissionId(Long permissionId);
	/*
	 * 删除权限
	 * @params roleId
	 * @return
	 */
	public void deletePermissionByRoleId(Long roleId);
	/*
	 * 获取用户的权限Id列表
	 * @params userId
	 * @return List<Long>
	 */
	public List<Long> findPermissionsByRoleId(Long roleId);
}
