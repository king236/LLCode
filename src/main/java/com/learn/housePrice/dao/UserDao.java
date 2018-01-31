package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.learn.housePrice.entity.Role;
import com.learn.housePrice.entity.User;

@Repository
public interface UserDao {

	List<User> getAll();
	
	User getOne(Long id);

	Long insert(User user);

	void update(User user);

	void delete(Long id);	
	
	List<User> selectByMap(Map<String, Object> params);
	
	User getUser(User user);
	
	List<Long> getRoles(Long userId);

	List<String> getRolesName(Long userId);
}
