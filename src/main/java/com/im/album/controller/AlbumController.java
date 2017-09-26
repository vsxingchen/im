package com.im.album.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.im.album.domain.Album;
import com.im.album.service.AlbumService;
import com.im.utils.JsonUtil;


/**
 * 相册
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	/**
	 * 发布相册
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		String jsonStr=request.getParameter("jsonStr");
		Album album = JSONObject.parseObject(jsonStr, Album.class);
		albumService.create(album);
		JsonUtil.writeJSON(null,response,200,"success");		
	}
	
	/**
	 * 获取相册
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		String userid=request.getParameter("userid");
		List<Album> albums=albumService.findByUserId(userid);
		JsonUtil.writeJSON(albums,response,200,"success");		
	}
	
	/**
	 * 获取好友以及自己的相册
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/alllist", method = RequestMethod.GET)
	@ResponseBody
	public void alllist(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		String userid=request.getParameter("userid");
		List<Album> albums=albumService.findAllByUserId(userid);
		JsonUtil.writeJSON(albums,response,200,"success");		
	}
	
	/**
	 * 根据ID删除相册
	 * @param baseGoods
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		albumService.delete(Integer.parseInt(id));
		JsonUtil.writeJSON(null,response,200,"success");		
	}
	
}
