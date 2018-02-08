package com.learn.housePrice.service;

import java.util.List;
import java.util.Map;

import com.learn.housePrice.entity.BaseEntity;

/*
 * 基础服务类
 * 实现数据增删改查基本操作
 */
public abstract interface IBaseService<T , ID> { // extends BaseEntity<ID>
	
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
	
	/*
	 * 通过参数列表查找
	 * @params map
	 * @return List<Role>
	 */
	public List<T> findByMapParams(Map<String, Object> map);
}
