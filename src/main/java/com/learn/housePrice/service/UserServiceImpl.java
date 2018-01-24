package com.learn.housePrice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		if(user.getId() != null){
			userDao.update(user);
		}else{
			userDao.insert(user);
		}
	}
	
}
