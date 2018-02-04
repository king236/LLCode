package com.learn.housePrice.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.housePrice.dao.BaseDao;

public abstract interface IBaseService<M extends Serializable>{

	protected BaseDao<M> mapper;
	
}
