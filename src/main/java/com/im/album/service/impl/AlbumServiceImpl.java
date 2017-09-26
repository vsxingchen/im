package com.im.album.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.album.dao.AlbumMapper;
import com.im.album.domain.Album;
import com.im.album.service.AlbumService;


@Service
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumMapper albumMapper;
	public void create(Album album) {
		album.setCreatetime(new Date());
		albumMapper.create(album);
	}
	public List<Album> findByUserId(String userId) {
		return albumMapper.findByUserId(userId);
	}
	public List<Album> findAllByUserId(String userId) {
		return  albumMapper.findAllByUserId(userId);
	}
	public void delete(int id) {
		albumMapper.delete(id);
	}

}
