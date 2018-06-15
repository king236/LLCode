package com.learn.housePrice.service.imp;

import java.util.ArrayList;
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
	public void grantRolePermissions(Long roleId, List<Long> permissionIds) {
		// TODO Auto-generated method stub
		//查找权限
		List<Long> rolePermissionsOld = roleDao.findPermissionIdsByRoleId(roleId);
		List<Long> rolePermissionsAdd = new ArrayList<>();
		List<Long> rolePermissionsDelete = new ArrayList<>();

		if (permissionIds == null || permissionIds.size() <= 0){
			return;
		}

		if (rolePermissionsOld != null && rolePermissionsOld.size() > 0){
			for (Long permissionId : rolePermissionsOld){
				if (!permissionIds.contains(permissionId)){
					rolePermissionsAdd.add(permissionId);
				}
			}
			for (Long permissionId : permissionIds){
				if (!rolePermissionsOld.contains(permissionId)){
					rolePermissionsDelete.add(permissionId);
				}
			}
		}
		roleDao.grantRolePermissions(roleId, rolePermissionsAdd.toArray(new Long[rolePermissionsAdd.size()]));
		roleDao.deleteRolePermission(roleId, rolePermissionsDelete);
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
