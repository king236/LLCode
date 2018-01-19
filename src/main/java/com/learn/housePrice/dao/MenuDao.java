package com.learn.housePrice.dao;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.Menu;

public interface MenuDao {
	
	int insert(Menu menu);
	
	Long getSortMax(Menu menu);
	
	List<Menu> getMenuChild(Map<String,Object> params);
	
	List<Menu> getMenuParent();
}