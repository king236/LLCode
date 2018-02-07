package com.learn.housePrice.dao;

import java.util.List;

import com.learn.housePrice.entity.BaseEntity;

/*
 * 基本的数据操作类
 * 实现增删改查功能
 */
public abstract interface BaseDao<T extends BaseEntity<ID>, ID> {
	/*
	 * 查找
	 */
	List<T> find();
	/*
	 * 通过id查找
	 * @param id
	 * @return T
	 */
	T findById(ID id);
	/*
	 * 保存
	 * @param model
	 * @return T
	 */
	ID insert(T model);
	/*
	 * 修改
	 * @param model
	 */
	void update(T model);
	/*
	 * 删除
	 * @param id
	 */
	void delete(ID id);
	
}
