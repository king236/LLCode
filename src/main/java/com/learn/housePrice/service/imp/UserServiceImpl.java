package com.learn.housePrice.service.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.dao.UserRoleDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userMapper;
	@Autowired
	UserRoleDao userRoleMapper;
	
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		if(user.getId() != null){
			userMapper.update(user);
		}else{
			user.setCreateTime(new Date());
			user.setStatus("0");
			userMapper.insert(user);
		}
	}
	
	@Override
	public void delete(Long userId){
		userMapper.delete(userId);
		userRoleMapper.deleteRoleByUserId(userId);
	}
	
	@Override
	public void grantUserRoles(Long id, Long [] roleIds){
		userRoleMapper.grantUserRoles(id, roleIds);
	}
}
