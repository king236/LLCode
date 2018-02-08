package com.learn.housePrice.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.dao.RoleDao;
import com.learn.housePrice.entity.Role;
import com.learn.housePrice.service.RoleService;

@Service
public class RoleServiceImp extends IBaseServiceImp<Role, Long>implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> findRolesByUserId(Long userId) {
		// TODO Auto-generated method stub
		return roleDao.findRolesByUserId(userId);
	}

	@Override
	public BaseDao<Role, Long> getDao() {
		// TODO Auto-generated method stub
		return roleDao;
	}

	@Override
	public List<Role> findByMapParams(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.findByMapParams(map);
	}

	@Override
	public void grantRolePermissions(Long roleId, Long[] permissionIds) {
		// TODO Auto-generated method stub
		roleDao.grantRolePermissions(roleId, permissionIds);
	}

	@Override
	public void delete(Long roleId) {
		roleDao.delete(roleId);
		roleDao.deleteRolePermissionByRoleId(roleId);
	}

	@Override
	public List<Long> findPermissionIdsByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return roleDao.findPermissionIdsByRoleId(roleId);
	}

}
