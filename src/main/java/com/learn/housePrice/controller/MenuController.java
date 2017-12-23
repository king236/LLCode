package com.learn.housePrice.controller;

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

import com.learn.housePrice.dao.MenuDao;
import com.learn.housePrice.entity.Menu;
import com.learn.housePrice.util.Result;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	@Autowired
	private MenuDao menuDao;
	
	@RequestMapping(value="/")
	public String index(){
		
		return "/menu/menu_main";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Result addMenu(Menu menu){
		Result result = new Result();
		try {
			if(StringUtils.isBlank(menu.getParentMenuId())){
				menu.setParentMenuId(null);
			}
			Long maxSort = menuDao.getSortMax(menu);
			menu.setSort((Long)(maxSort+1));
			int id = menuDao.insert(menu);
			if(id == 1){
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
	
	@RequestMapping(value="getMenu", method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenu(){
		Map<String,Object> params = new HashMap<>();
		List<Menu> menuList = menuDao.getMenu(params);
		System.out.println(menuList);
	 	return menuList;
	}
}
