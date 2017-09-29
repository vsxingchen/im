package com.im.userlist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.user.domain.User;
import com.im.user.service.UserService;
import com.im.userlist.domain.UserList;
import com.im.userlist.service.UserListService;
import com.im.userlist.vo.UserListVo;
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
	@Autowired
	private UserService userService;
	/**
	 * 添加通讯录
	 */
	@RequestMapping(value = { "/create" }, method = { RequestMethod.POST})
	public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String mytel=request.getParameter("mytel");//自己手机号
		String tel=request.getParameter("tel"); //好友手机号
		User users=userService.findByTel(tel);
		User myuser=userService.findByTel(mytel);
        if(users==null){
        	JsonUtil.writeJSON(null, response,301,"用户不存在");
        }else{
		UserList user=new UserList();
		user.setTel(tel);
	    user.setUserid(myuser.getId());
		user.setName(users.getNickname());
		UserList userList=userListService.findByTelAndUserId(user);
		
		UserList user2=new UserList();
		user2.setTel(mytel);
	    user2.setUserid(users.getId());
		UserList userList2=userListService.findByTelAndUserId(user2);
        if(userList2==null){
		if(userList==null){
			userListService.create(user);
			JsonUtil.writeJSON(null, response,200,"申请成功");
		}else{
			JsonUtil.writeJSON(null, response,300,"用户已存在");
		}
        }else{
        	JsonUtil.writeJSON(null, response,300,"好友已存在");
        }
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
			List<UserListVo> users=userListService.findList(userList);
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
			
			UserList list=userListService.findById(id);
			String tel=list.getTel();
			User user2=userService.findByTel(tel);
			
			User user=userService.findById(userId);//自己
			UserList userList2=new UserList();
			userList2.setTel(user.getTel());
			userList2.setStatus(status);
			userList2.setName(user.getNickname());
			userList2.setUserid(user2.getId());
			
			userListService.create(userList2);

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
