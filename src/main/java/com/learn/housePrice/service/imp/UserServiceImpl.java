package com.learn.housePrice.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.dao.UserRoleDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;

@Service 
public class UserServiceImpl extends IBaseServiceImp<User, Long> implements UserService{

	@Autowired
	UserRoleDao userRoleMapper;
	
	
	@Autowired  
    @Qualifier("userDao")  
    private UserDao dao;  
	
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		if(user.getId() != null){
			dao.update(user);
		}else{
			user.setCreateTime(new Date());
			user.setStatus("0");
			dao.insert(user);
		}
	}
	
	@Override
	public void delete(Long userId){
		dao.delete(userId);
		userRoleMapper.deleteRoleByUserId(userId);
	}
	
	@Override
	public void grantUserRoles(Long id, Long [] roleIds){
		userRoleMapper.grantUserRoles(id, roleIds);
	}

	@Override
	public User checkUserLogin(User user) {
		Map<String, Object> params = new HashMap<>();
		params.put("nickname", user.getNickname());
		params.put("pswd", user.getPswd());
		List<User> userList = dao.selectByMap(params);
		if(userList != null && userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public BaseDao<User, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

}
