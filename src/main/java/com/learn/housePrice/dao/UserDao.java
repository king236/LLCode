package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.learn.housePrice.entity.User;


public interface UserDao extends BaseDao<User, Long>{
	/*
	 * 验证用户登录
	 * @params Map<String, Object>
	 * 	nickname    用户名
	 * 	pswd 		密码
	 * @return List<User>
	 */
	List<User> checkUserLogin(Map<String, Object> params);
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
	 * 获取用户的角色Id列表
	 * @params userId
	 * @return List<Long>
	 */
	public List<Long> getRolesIdsByUserId(Long userId);
}
