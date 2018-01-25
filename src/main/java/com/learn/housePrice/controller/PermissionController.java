package com.learn.housePrice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.housePrice.dao.PermissionDao;
import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.util.Result;

@Controller
@RequestMapping(value="/admin/permission")
public class PermissionController {
	
	@Autowired
	private PermissionDao permissionDao;
	
	@RequestMapping(value="/index")
	public String index(){		
		return "/admin/permission/index";
	}
	
	@RequestMapping(value="/leftPermissionData", method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> leftPermissionData(){
		List<Map<String, Object>> permissionAll = new ArrayList<>();
		List<Permission> permissionParentList = permissionDao.getPermissionParent();
		
		if(permissionParentList != null && permissionParentList.size() > 0){
			for(Permission permission : permissionParentList){
				Map<String, Object> map = new HashMap<>();
				map.put("permissionName", permission.getPermissionName());
				
				Map<String,Object> params = new HashMap<>();
				params.put("parentId", permission.getId());
				List<Permission> permissionChildList = permissionDao.getPermissionChild(params);
				if(permissionChildList != null && permissionChildList.size() > 0){
					map.put("children", permissionChildList);				
				}
				
				permissionAll.add(map);
			}
		}
	 	return permissionAll;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Result addPermission(Permission permission){
		Result result = new Result();
		try {
			if(StringUtils.isBlank(permission.getParentId())){
				permission.setParentId(null);
			}
			Long maxSort = permissionDao.getSortMax(permission);
			permission.setSort((Long)(maxSort+1));
			Long id = permissionDao.insert(permission);
			if(id == 1L){
				result.setResult("success");
			}else{
				result.setResult("error");
				result.setMessage("菜单插入失败。");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setResult("error");
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping(value="/getPermission", method=RequestMethod.GET)
	@ResponseBody
	public List<Permission> getPermission(){
		
		List<Permission> permissionParentList = permissionDao.getPermissionParent();
		List<Permission> permissionAllList = new ArrayList<Permission>();
		if(permissionParentList != null && permissionParentList.size() > 0){
			for(Permission permission : permissionParentList){
				permissionAllList.add(permission);
				Map<String,Object> params = new HashMap<>();
				params.put("parentId", permission.getId());
				List<Permission> permissionChildList = permissionDao.getPermissionChild(params);
				if(permissionChildList != null && permissionChildList.size() > 0){
					permissionAllList.addAll(permissionChildList);					
				}
			}
		}
	 	return permissionAllList;
	}
}
