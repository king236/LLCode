package com.learn.housePrice.controller;

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
import com.github.pagehelper.PageInfo;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.User;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	@Autowired
	private UserDao userMapper;
	
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
    	PageInfo<User> userPage = new PageInfo<>(userMapper.getAll());
		return userPage;
	}
	
	@RequestMapping("/getUserInfo/{id}")
	public String getUserInfo(@PathVariable("id") Long id, Model model){
		User user = userMapper.getOne(id);
		model.addAttribute("user", user);
		return "/user/edit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		return "admin/user/form";
	}
}
