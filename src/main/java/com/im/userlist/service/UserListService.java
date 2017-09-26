package com.im.userlist.service;


import java.util.List;

import com.im.userlist.domain.UserList;



public interface UserListService {
	
	/**
	 * 新增通讯录
	 * @param userList
	 */
	void create(UserList userList);

	/**
	 * 查询通讯录列表
	 * @param userList
	 */
	List<UserList> findList(UserList userList);
	
	/**
	 * 根据tel和userId查询通讯录
	 * @param userList
	 */
	UserList findByTelAndUserId(UserList userList);
	
	/**
	 * 删除通讯录
	 * @param userList
	 */
	void delete(UserList userList);
	
	/**
	 * 修改通讯录
	 * @param userList
	 */
	void update(UserList userList);
		
}
