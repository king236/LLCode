package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.learn.housePrice.entity.Role;
import com.learn.housePrice.entity.User;


public interface UserDao extends BaseDao<User, Long>{

	List<User> selectByMap(Map<String, Object> params);
	
	List<Long> getRoles(Long userId);

	List<String> getRolesName(Long userId);
}
