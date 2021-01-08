package com.spring.activitystream.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.activitystream.dao.FriendCircleDAO;
import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;
import com.spring.activitystream.service.FriendCircleService;

@Service
public class FriendCircleServiceImpl implements FriendCircleService {

	@Autowired
	private FriendCircleDAO fcDAO;
	
	public boolean addFriendCircle(FriendCircle fc) {
		return fcDAO.addFriendCircle(fc);
	}
	
	@Override
	public List<User> getAllFriends(FriendCircle fc) {
		return fcDAO.getAllFriends(fc);
	}

	@Override
	public List<FriendCircle> getFriendCirclesLikeName(String name) {
		return fcDAO.getFriendCirclesLikeName(name);
	}

}
