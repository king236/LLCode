package com.learn.housePrice.service;

import java.io.Serializable;
import java.util.List;

import com.learn.housePrice.dao.BaseDao;

/*
 * 基础服务类
 * 实现数据增删改查基本操作
 */
public abstract interface IBaseService<T extends Serializable>{
	
	/*
	 * 查找
	 */
	List<T> find();
	/*
	 * 通过id查找
	 * @param id
	 * @return T
	 */
	T findById(Long id);
	/*
	 * 保存
	 * @param model
	 * @return T
	 */
	Long insert(T model);
	/*
	 * 修改
	 * @param model
	 */
	void update(T model);
	/*
	 * 删除
	 * @param id
	 */
	void delete(Long id);
}
