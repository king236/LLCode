package com.learn.housePrice.common.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

/** 
 * 自定义一个ShiroTagFreeMarkerConfigurer继承Spring本身提供的FreeMarkerConfigurer
 * 目的是在FreeMarker的Configuration中添加shiro的配置 
 */  
@Component
public class FreeMarkerConfigExtend extends FreeMarkerConfigurer{
	
	@Override  
	public void afterPropertiesSet() throws IOException, TemplateException {  
        super.afterPropertiesSet();
        Configuration cfg = this.getConfiguration();
        cfg.setSharedVariable("shiro", new ShiroTags());//shiro标签
        cfg.setNumberFormat("#");//防止页面输出数字,变成2,000
        //可以添加很多自己的要传输到页面的[方法、对象、值]
	}
	
}
