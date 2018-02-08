package com.learn.housePrice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.housePrice.common.config.PropertiesConfig;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

	@Autowired
	private PropertiesConfig config;
	
	
	@Test
	public void propertiesTest() throws Exception {
		String userName = config.getDataUserName();
		System.out.println(userName);
	}
	
}
