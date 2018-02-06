package com.learn.housePrice.service.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.IBaseService;

public class IBaseServiceImp implements IBaseService<Serializable> {

	@Autowired
	BaseDao<Serializable> dao;
	
	@Override
	public List<Serializable> find() {
		// TODO Auto-generated method stub
		return dao.find();
	}

	@Override
	public Serializable findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Long insert(Serializable model) {
		// TODO Auto-generated method stub
		return dao.insert(model);
	}

	@Override
	public void update(Serializable model) {
		// TODO Auto-generated method stub
		dao.update(model);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
