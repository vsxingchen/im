package com.im.user.controller;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.HttpResponse;
import com.im.user.domain.User;
import com.im.user.service.UserService;
import com.im.utils.JsonUtil;
import com.im.utils.SmsSend;

/**
 * 用户接口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController{
	@Autowired
	private UserService userService;
	
	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/regist" }, method = { RequestMethod.POST})
	public void regist(HttpServletRequest request, HttpServletResponse response,String name) throws Exception {
		request.setCharacterEncoding("utf-8");
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		String nickName=request.getParameter("nickName");
		
		User user=userService.findByTel(tel);
		if(user==null){
			User use1=new User();
			use1.setTel(tel);
			use1.setPassword(password);
			use1.setNickname(nickName);
			userService.create(use1);
			JsonUtil.writeJSON(null, response,200,"注册成功");
		}else{
			JsonUtil.writeJSON(null, response,200,"用户已存在");
		}
	}
	/**
	 * 登陆
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST})
	public void login(HttpServletRequest request, HttpServletResponse response,String tel,String password) throws Exception {
		request.setCharacterEncoding("utf-8");
		User user=userService.findByTel(tel);
		if(user!=null){
			if(password.equals(user.getPassword())){
				JsonUtil.writeJSON(user, response,200,"登陆成功");
			}else{
				JsonUtil.writeJSON(null, response,400,"用户名密码错误");
			}
		}else{
			JsonUtil.writeJSON(null, response,300,"用户不存在");
		}
	}
	
	/**
	 * 搜索好友
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/search" }, method = { RequestMethod.GET})
	public void search(HttpServletRequest request, HttpServletResponse response,String tel,String password) throws Exception {
		String jsonStr=request.getParameter("jsonStr");
		User user = JSONObject.parseObject(jsonStr, User.class);
		List<User> users=userService.findList(user);
		JsonUtil.writeJSON(users, response,200,"success");
	}
	
	/**
	 * 修改个人资料
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST})
	public void update(HttpServletRequest request, HttpServletResponse response,String tel,String password) throws Exception {
		String jsonStr=request.getParameter("jsonStr");
		User user = JSONObject.parseObject(jsonStr, User.class);
		userService.update(user);
		JsonUtil.writeJSON(null, response,200,"修改成功");
	}
	
	
	/**
	 * 根据tel查询用户
	 * @return
	 */
	@RequestMapping(value = { "/findByTel" }, method = { RequestMethod.GET})
	public void findByTel(HttpServletRequest request, HttpServletResponse response,String tel) throws Exception {
		User user=userService.findByTel(tel);
		JsonUtil.writeJSON(user, response,200,"success");
		
	}
}
