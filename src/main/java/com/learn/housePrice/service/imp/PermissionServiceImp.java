package com.learn.housePrice.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.dao.PermissionDao;
import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.service.PermissionService;

public class PermissionServiceImp extends IBaseServiceImp<Permission, Long> implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public List<Permission> findByMapParams(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return permissionDao.findByMapParams(map);
	}

	@Override
	public Long getSortMax(Permission permission) {
		// TODO Auto-generated method stub
		return permissionDao.getSortMax(permission);
	}

	@Override
	public BaseDao<Permission, Long> getDao() {
		// TODO Auto-generated method stub
		return permissionDao;
	}

	@Override
	public void delete(Long permissionId) {
		permissionDao.delete(permissionId);
		permissionDao.deleteRolePermissionByPermissionId(permissionId);
	};

}