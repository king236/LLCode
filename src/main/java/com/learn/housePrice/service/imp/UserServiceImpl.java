package com.learn.housePrice.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.dao.UserRoleDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;

@Service
public class UserServiceImpl extends IBaseServiceImp<User> implements UserService{

	@Autowired
	UserRoleDao userRoleMapper;
	
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		if(user.getId() != null){
			dao.update(user);
		}else{
			user.setCreateTime(new Date());
			user.setStatus("0");
			dao.insert(user);
		}
	}
	
	
	
	@Override
	public void delete(Long userId){
		dao.delete(userId);
		userRoleMapper.deleteRoleByUserId(userId);
	}
	
	@Override
	public void grantUserRoles(Long id, Long [] roleIds){
		userRoleMapper.grantUserRoles(id, roleIds);
	}



	@Override
	public List<User> find() {
		// TODO Auto-generated method stub
		return dao.find();
	}



	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}



	@Override
	public Long insert(User model) {
		// TODO Auto-generated method stub
		model.setCreateTime(new Date());
		model.setStatus("0");
		return dao.insert(model);
	}



	@Override
	public void update(User model) {
		// TODO Auto-generated method stub
		dao.update(model);
	}
}
