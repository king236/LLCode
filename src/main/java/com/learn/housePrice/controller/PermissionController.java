package com.learn.housePrice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.housePrice.dao.MenuDao;
import com.learn.housePrice.dao.PermissionDao;
import com.learn.housePrice.entity.Menu;
import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.util.Result;

@Controller
@RequestMapping(value="/admin/permission")
public class PermissionController {
	
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private MenuDao menuDao;
	
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
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Result addPermission(Permission permission){
		try {
			//if(StringUtils.isBlank(permission.getParentId())){
			//	permission.setParentId(null);
			//}
			Long maxSort = permissionDao.getSortMax(permission);
			permission.setSort((Long)(maxSort+1));
			Long id = permissionDao.insert(permission);
			if(id == 1L){
				return Result.success("权限插入成功");
			}else{
				return Result.failure("权限插入失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable Long id, Model model) {
		if(id > 0){
			model.addAttribute("permission", permissionDao.getOne(id));
		}
		return "admin/permission/form";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		try {
			Permission permission = permissionDao.getOne(id);
			if( permission.getParentId() != 0 ){
				model.addAttribute("permissionParent", permissionDao.getOne(permission.getParentId()));
			}
			model.addAttribute("permission", permissionDao.getOne(id));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "admin/permission/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Result edit(Permission permission){
		try {
			permissionDao.update(permission);
			return Result.success("修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result delete(@PathVariable Long id){
		try {
			permissionDao.delete(id);
			return Result.success("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
	}
	
	@RequestMapping(value="/getPermission", method = RequestMethod.GET)
	@ResponseBody
	public List<Permission> getPermission(){
		
		/*List<Permission> permissionParentList = permissionDao.getPermissionParent();
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
		}*/
	 	return permissionDao.getAll();
	}
	
	
	@RequestMapping(value="getMenu", method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenu(){
		
		List<Menu> menuParentList = menuDao.getMenuParent();
		List<Menu> menuAllList = new ArrayList<Menu>();
		if(menuParentList != null && menuParentList.size() > 0){
			for(Menu menu : menuParentList){
				menuAllList.add(menu);
				Map<String,Object> params = new HashMap<>();
				params.put("parentMenuId", menu.getId());
				List<Menu> menuChildList = menuDao.getMenuChild(params);
				if(menuChildList != null && menuChildList.size() > 0){
					menuAllList.addAll(menuChildList);					
				}
			}
		}
	 	return menuAllList;
	}
}
