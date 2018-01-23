package com.learn.housePrice.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.housePrice.dao.RoleDao;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.Role;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import com.learn.housePrice.util.Result;

@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleDao roleMapper;
	
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
    	PageInfo<Role> rolePage = new PageInfo<>(roleMapper.getAll());
		return rolePage;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Long id, Model model){
		User user = userMapper.getOne(id);
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
			userMapper.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
		return Result.success("操作成功");
	}
	
	@RequestMapping(value= "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Result edit(User user){
		try {
			if(user.getId() != null){
				userMapper.update(user);
			}else{
				userMapper.insert(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
		return Result.success("操作成功");
	}
	
}
