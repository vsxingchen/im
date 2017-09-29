package com.im.userlist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.user.dao.UserMapper;
import com.im.user.domain.User;
import com.im.userlist.dao.UserListMapper;
import com.im.userlist.domain.UserList;
import com.im.userlist.service.UserListService;
import com.im.userlist.vo.UserListVo;



@Service
public class UserListServiceImpl implements UserListService{
	@Autowired
	private UserListMapper userListDao;


	
	public void create(UserList userList) {
		userListDao.create(userList);
	}

	
	public List<UserListVo> findList(UserList userList) {
		return userListDao.findList(userList);
	}

	
	public UserList findByTelAndUserId(UserList userList) {
		return userListDao.findByTelAndUserId(userList);
	}

	
	public void delete(UserList userList) {
		userListDao.delete(userList);
	}

	
	public void update(UserList userList) {
		userListDao.update(userList);
	}


	public UserList findById(int id) {
		return userListDao.findById(id);
	}
}
