package com.learn.housePrice.service.imp;

import com.learn.housePrice.dao.BaseDao;
import com.learn.housePrice.dao.UserDao;
import com.learn.housePrice.entity.User;
import com.learn.housePrice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service 
public class UserServiceImpl extends IBaseServiceImp<User, Long> implements UserService{

	@Autowired
    private UserDao userDao;  
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
		userDao.deleteRoleByUserId(userId);
	}
	
	@Override
	public void grantUserRoles(Long id, Long [] roleIds){
		userDao.grantUserRoles(id, roleIds);
	}

	@Override
	public User checkUserLogin(User user) {
		Map<String, Object> params = new HashMap<>();
		params.put("nickname", user.getNickname());
		params.put("pswd", user.getPswd());
		List<User> userList = userDao.checkUserLogin(params);
		if(userList != null && userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public BaseDao<User, Long> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	@Override
	public List<User> findByMapParams(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.findByMapParams(map);
	}


	@Override
	public List<Long> getRolesIdsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userDao.getRolesIdsByUserId(userId);
	}

	@Override
	public User findUserByName(String userName) {
		List<User> userList = userDao.findUserByName(userName);
		if (userList != null && userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}

}
