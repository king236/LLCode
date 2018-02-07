package com.learn.housePrice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRoleService {

	/*
	 * 用户授权
	 * @params userId,roleIds
	 * @return
	 */
	public void grantUserRoles(Long userId, Long [] roleIds);
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
