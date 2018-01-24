package com.learn.housePrice.dao;

import java.util.List;


public interface BaseDao<T> {

	List<T> getAll();
	
	T getOne(Long id);

	Long insert(T model);

	void update(T model);

	void delete(Long id);
	
}
