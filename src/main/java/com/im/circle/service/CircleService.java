package com.im.circle.service;

import java.util.List;

import com.im.circle.domain.Circle;


public interface CircleService {

	/**
     * 新增
     * @param album
     */
	void create(Circle circle);
	/**
	 * 根据用户ID获取圈子
	 * @param userId
	 * @return
	 */
	List<Circle> findByUserId(String userId);
	
	/**
	 * 获取好友以及自己的圈子
	 * @param userId
	 * @return
	 */
	List<Circle> findAllByUserId(String userId);
	
	/**
	 * 根据ID删除圈子
	 * @param id
	 */
	void delete(int id);
}
