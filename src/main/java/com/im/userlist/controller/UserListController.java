package com.im.userlist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.user.domain.User;
import com.im.userlist.domain.UserList;
import com.im.userlist.service.UserListService;
import com.im.utils.JsonUtil;

/**
 * 通讯录接口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userList")
public class UserListController {

	@Autowired
	private UserListService userListService;
	
	/**
	 * 添加通讯录
	 */
	@RequestMapping(value = { "/create" }, method = { RequestMethod.POST})
	public void create(HttpServletRequest request, HttpServletResponse response,int userId) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name"); 	
		String tel=request.getParameter("tel"); 	
		UserList user=new UserList();
		user.setTel(tel);
	    user.setUserid(userId);
		user.setName(name);
		UserList userList=userListService.findByTelAndUserId(user);
		if(userList==null){
			userListService.create(user);
			JsonUtil.writeJSON(null, response,200,"申请成功");
		}else{
			JsonUtil.writeJSON(null, response,300,"用户已存在");
		}
	}
	/**
	 * 通讯录列表
	 * @return
	 */
	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET})
	public void list(HttpServletRequest request, HttpServletResponse response,int userId) throws Exception {
			UserList userList=new UserList();
			userList.setUserid(userId);
			List<UserList> users=userListService.findList(userList);
			JsonUtil.writeJSON(users, response,200,"success");
		
	}
	
	/**
	 * 同意添加通讯录
	 */
	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST})
	public void update(HttpServletRequest request, HttpServletResponse response,int userId,String status,int id) throws Exception {
	
		if("2".equals(status)){//删除
			UserList userList=new UserList();
			userList.setUserid(userId);
			userList.setId(id);
			userListService.delete(userList);
			JsonUtil.writeJSON(null, response,300,"删除成功");
		}else if("1".equals(status)){//同意
			UserList userList=new UserList();
			userList.setUserid(userId);
			userList.setId(id);
			userList.setStatus(status);
			userListService.update(userList);
			JsonUtil.writeJSON(null, response,200,"同意");
		}
	}
	

	
	/**
	 * 根据tel删除通讯录
	 * @return
	 */ 
	@RequestMapping(value = { "/delete" }, method = { RequestMethod.POST})
	public void delete(HttpServletRequest request, HttpServletResponse response,String tel,int userId) throws Exception {
		UserList user=new UserList();
		user.setTel(tel);
		user.setUserid(userId);
		userListService.delete(user);
		JsonUtil.writeJSON(user, response,200,"删除成功");
		
	}
	
}
