package com.im.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.user.dao.UserMapper;
import com.im.user.domain.User;
import com.im.user.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User findByTel(String tel) {
		return userMapper.findByTel(tel);
	}

	public void create(User user) {
		userMapper.create(user);
	}

	public void update(User user) {
		userMapper.update(user);		
	}

	public List<User> findList(User user) {
		return userMapper.findList(user);
	}

}
