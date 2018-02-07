package com.learn.housePrice.dao;

import com.learn.housePrice.entity.Permission;

public interface PermissionDao extends BaseDao<Permission, Long>{

	/*
	 * 获得新增菜单在当前层级的排序
	 * @params permission
	 * @return Long
	 */
	public Long getSortMax(Permission permission);
	
}
