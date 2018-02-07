package com.learn.housePrice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.housePrice.dao.UserRoleDao;
import com.learn.housePrice.service.UserRoleService;

@Service
public class UserRoleServiceImp implements UserRoleService{

	@Autowired
	private UserRoleDao dao;
	
	@Override
	public void grantUserRoles(Long userId, Long[] roleIds) {
		// TODO Auto-generated method stub
		dao.grantUserRoles(userId, roleIds);
	}

	@Override
	public void deleteRoleByUserId(Long userId) {
		// TODO Auto-generated method stub
		dao.deleteRoleByUserId(userId);
	}

	@Override
	public void deleteRoleByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		dao.deleteRoleByRoleId(roleId);
	}

	@Override
	public List<Long> getRolesIdsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return dao.getRolesIdsByUserId(userId);
	}

}
