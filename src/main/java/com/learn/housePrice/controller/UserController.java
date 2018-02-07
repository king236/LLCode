package com.learn.housePrice.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.housePrice.dao.RoleDao;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.dao.UserRoleDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import com.learn.housePrice.util.Result;

@Controller
@RequestMapping("/admin/user")
public class UserController {
/*	
	@Autowired
	private RoleDao roleMapper;
	
	@Autowired
	private UserRoleDao userRoleMapper;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(){
		return "admin/user/index";
	}
	
	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public PageInfo<User> getUserList(HttpServletRequest request){
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
    	List<User> userList = userService.find();
    	PageInfo<User> userPage = new PageInfo<>(userList);
		return userPage;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Long id, Model model){
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "admin/user/form";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		return "admin/user/form";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteUser(@PathVariable("id") Long id){
		try {
			userService.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Result edit(User user){
		try {
			userService.saveOrUpdate(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
	public String grant(@PathVariable Long id, Model model){
		try{
			model.addAttribute("user", userService.findById(id));
			model.addAttribute("roles", roleMapper.find());
			model.addAttribute("roleIds", userService.getRoles(id));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/admin/user/grant";
	}
	
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result grant(@PathVariable Long id, Long [] roleIds){
		try {
			userService.grantUserRoles(id, roleIds);
			return Result.success("关联角色成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure("关联角色失败");
		}
	}*/
}
