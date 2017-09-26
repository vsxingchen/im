package com.im.circle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.circle.dao.CircleMapper;
import com.im.circle.domain.Circle;
import com.im.circle.service.CircleService;

@Service
public class CircleServiceImpl implements CircleService {
	@Autowired
	private CircleMapper circleMapper;
	
	public void create(Circle circle) {
		circleMapper.create(circle);
	}

	public List<Circle> findByUserId(String userId) {
		return circleMapper.findByUserId(userId);
	}

	public List<Circle> findAllByUserId(String userId) {
		return circleMapper.findAllByUserId(userId);
	}

	public void delete(int id) {
		circleMapper.delete(id);
	}

}
