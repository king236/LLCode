package com.learn.housePrice.service.imp;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.entity.BaseEntity;
import com.learn.housePrice.service.IBaseService;

@Transactional
public abstract  class IBaseServiceImp<T extends BaseEntity<M>, M> implements IBaseService<T, M>{

    public abstract  BaseDao<T,M> getDao();
	
	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return (List<T>) getDao().find();
	}

	@Override
	public T findById(M id) {
		// TODO Auto-generated method stub
		return (T) getDao().findById(id);
	}

	@Override
	public M insert(T model) {
		// TODO Auto-generated method stub
		return getDao().insert(model);
	}

	@Override
	public void update(T model) {
		// TODO Auto-generated method stub
		getDao().update(model);
	}

	@Override
	public void delete(M id) {
		// TODO Auto-generated method stub
		getDao().delete(id);
	}

    
}
