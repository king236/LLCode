package com.learn.housePrice.service.imp;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.dao.PermissionDao;
import com.learn.housePrice.dao.RoleDao;
import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.entity.Role;
import com.learn.housePrice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImp extends IBaseServiceImp<Permission, Long> implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private RoleDao roleDao;
	
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

	@Override
	public List<Permission> findPermissionByUserId(Long userId){
		List<Role> roleList = roleDao.findRolesByUserId(userId);
		List<Permission> permissionList = new ArrayList<>();
		if (roleList != null && roleList.size() > 0){
			for (Role role : roleList){
				List<Permission> permissions = permissionDao.findPermissionByRoleId(role.getId());
				if (permissions != null && permissions.size() > 0){
					permissionList.addAll(permissions);
				}
			}
		}
		return permissionList;
	}
}
