package com.learn.housePrice.service;

import java.util.List;

import com.learn.housePrice.entity.Role;

public interface RoleService extends IBaseService<Role, Long>{
	
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
	public void grantRolePermissions( Long roleId, Long [] permissionIds);
	
	/*
	 * 通过roleId删除权限关联表相关信息
	 * @params roleId
	 * @return
	 */
	//public void deleteRolePermissionByRoleId(Long roleId);
	
	/*
	 * 获取用户的权限Id列表
	 * @params userId
	 * @return List<Long>
	 */
	public List<Long> findPermissionIdsByRoleId(Long roleId);
}
