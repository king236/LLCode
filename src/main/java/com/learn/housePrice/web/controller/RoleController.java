package com.learn.housePrice.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.housePrice.entity.Role;
import com.learn.housePrice.service.RoleService;
import com.learn.housePrice.common.util.Result;

import java.util.List;


@Controller
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/index")
	public String index(){
		return "admin/role/index";
	}
	
	@RequestMapping(value="/getRoleList", method=RequestMethod.POST)
	@ResponseBody
	public PageInfo<Role> getRoleList(HttpServletRequest request){
		int page = 1;
    	int size = 10;
    	Sort sort = null;
    	try {
    		String sortName = request.getParameter("sortName");
    		String sortOrder = request.getParameter("sortOrder");
    		if(StringUtils.isNoneBlank(sortName) && StringUtils.isNoneBlank(sortOrder)){
    			if(sortOrder.equalsIgnoreCase("desc")){
    				sort = new Sort(Direction.DESC, sortName);
    			}else{
    				sort = new Sort(Direction.ASC, sortName);
    			}
    		}
    		page = Integer.parseInt(request.getParameter("pageNumber")) - 1;
    		size = Integer.parseInt(request.getParameter("pageSize"));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	PageHelper.startPage(page, size);
    	PageInfo<Role> rolePage = new PageInfo<>(roleService.find());
		return rolePage;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Long id, Model model){
		Role role = roleService.findById(id);
		model.addAttribute("role", role);
		return "admin/role/form";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		return "admin/role/form";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteRole(@PathVariable("id") Long id){
		try {
			roleService.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
		return Result.success("操作成功");
	}
	
	@RequestMapping(value= "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Result edit(Role role){
		try {
			if(role.getId() != null){
				roleService.update(role);
			}else{
				roleService.insert(role);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
	public String grant(@PathVariable Long id, Model model){
		try{
			model.addAttribute("role", roleService.findById(id));			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/admin/role/grant";
	}
	
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result grant(@PathVariable Long id,@RequestBody List<Long> permissionIds){//
		try {
			roleService.grantRolePermissions(id, permissionIds);
			return Result.success("关联角色成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure("关联角色失败");
		}
	}
}
