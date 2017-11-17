package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.User;

public interface UserDao {

	List<User> getAll();
	
	User getOne(Long id);

	Long insert(User user);

	void update(User user);

	void delete(Long id);	
	
	List<User> selectByMap(Map<String, Object> params);
}
