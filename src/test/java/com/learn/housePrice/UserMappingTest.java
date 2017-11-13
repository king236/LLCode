package com.learn.housePrice;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.housePrice.entity.User;
import com.learn.housePrice.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMappingTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		
		for(int i=0; i<8; i++){
			User user =  new User();
			user.setNickname("test" + i);
			user.setPswd("testPSWD" + i);
			user.setEmail("testEMAIL" + i);
			user.setStatus("0");
			user.setCreateTime(new Date());
			UserMapper.insert(user);
		}
		Assert.assertEquals(8, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = UserMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		User user = UserMapper.getOne(2L);
		System.out.println(user.toString());
		user.setNickname("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(2L).getNickname())));
	}
}
