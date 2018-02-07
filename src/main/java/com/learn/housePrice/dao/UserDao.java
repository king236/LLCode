package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

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
	
}
