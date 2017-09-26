package com.im.circle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.im.circle.domain.Circle;
import com.im.circle.service.CircleService;
import com.im.utils.JsonUtil;

/**
 * 圈子
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/circle")
public class CircleController {
	
	@Autowired
    private CircleService circleService;
	/**
	 * 发布圈子
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    //获取用户
		String jsonStr=request.getParameter("jsonStr");
		Circle circle = JSONObject.parseObject(jsonStr, Circle.class);
		circleService.create(circle);
		JsonUtil.writeJSON(null,response,200,"success");		
	}
	
	/**
	 * 获取圈子
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    //获取用户
		String userid=request.getParameter("userid");
		List<Circle> albums=circleService.findByUserId(userid);
		JsonUtil.writeJSON(albums,response,200,"success");		
	}
	
	/**
	 * 根据ID删除圈子
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		circleService.delete(Integer.parseInt(id));
		JsonUtil.writeJSON(null,response,200,"success");		
	}
}
