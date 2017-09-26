package com.im.album.dao;

import java.util.List;

import com.im.album.domain.Album;

public interface AlbumMapper {
    
	/**
     * 新增
     * @param album
     */
	void create(Album album);
	
	/**
	 * 根据用户ID获取相册
	 * @param userId
	 * @return
	 */
	List<Album> findByUserId(String userId);
	
	/**
	 * 获取好友以及自己的相册
	 * @param userId
	 * @return
	 */
	List<Album> findAllByUserId(String userId);
	
	/**
	 * 根据ID删除相册
	 * @param id
	 */
	void delete(int id);
}