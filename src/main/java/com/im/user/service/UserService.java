package com.im.user.service;

import java.util.List;

import com.im.user.domain.User;
import com.im.user.vo.UserVo;

public interface UserService {
	/**
	    * 根据手机号查询用户
	    * @param tel
	    * @return
	    */
	   User	findByTel(String tel);
	   
	   /**
	    * 新建用户
	    * @param user
	    */
	   void create(User user);
       
	   /**
	    * 根据手机号修改用户
	    * @param user
	    */
	   void update(User user);
       
	   /**
	    * 按条件搜索用户
	    * @param user
	    * @return
	    */
	    List<User> findList(UserVo user);
		/**
		 * 根据手机号查询用户
		 * @param tel
		 * @return
		 */
		User findById(int id);
     
}
