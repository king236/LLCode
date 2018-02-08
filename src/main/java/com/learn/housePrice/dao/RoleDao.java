package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.learn.housePrice.entity.Role;

public interface RoleDao extends BaseDao<Role, Long>{
	/*
	 * 获取用户角色
	 * @params userId
	 * @return List<Role>
	 */
	public List<Role> findRolesByUserId(Long userId);

	/*
	 * 角色关联权限
	 * @params roleId,permissionIds
	 * @return
	 */
	public void grantRolePermissions(@Param("roleId") Long roleId, @Param("permissionIds") Long [] permissionIds);
	
	/*
	 * 通过roleId删除权限关联表相关信息
	 * @params roleId
	 * @return
	 */
	public void deleteRolePermissionByRoleId(Long roleId);
	
	/*
	 * 获取用户的权限Id列表
	 * @params userId
	 * @return List<Long>
	 */
	public List<Long> findPermissionIdsByRoleId(Long roleId);
}
