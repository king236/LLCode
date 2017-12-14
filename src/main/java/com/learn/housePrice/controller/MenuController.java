package com.learn.housePrice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	@RequestMapping(value="/")
	public String index(){
		
		return "/menu/menu_main";
	}
	
}
