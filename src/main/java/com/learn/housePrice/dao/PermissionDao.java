package com.learn.housePrice.dao;

import com.learn.housePrice.entity.Permission;

import java.util.List;

public interface PermissionDao extends BaseDao<Permission, Long>{

	/*
	 * 获得新增菜单在当前层级的排序
	 * @params permission
	 * @return Long
	 */
	public Long getSortMax(Permission permission);
	/*
	 * 通过permissionId删除权限关联表相关信息
	 * @params permissionId
	 * @return
	 */
	public void deleteRolePermissionByPermissionId(Long permissionId);

	/*
	 * 查找用户权限
	 * @params userId
	 * @return
	 */
	public List<Permission> findPermissionByRoleId(Long roleId);
}
