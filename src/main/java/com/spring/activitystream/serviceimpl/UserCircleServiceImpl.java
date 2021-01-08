package com.spring.activitystream.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.activitystream.dao.UserCircleDAO;
import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;
import com.spring.activitystream.service.UserCircleService;

@Service
public class UserCircleServiceImpl implements UserCircleService {

	@Autowired
	private UserCircleDAO userCircleDAO;
	
	@Override
	public boolean addFriend(int friendId, int friendCircleId) {
		return userCircleDAO.addFriend(friendId, friendCircleId);
	}

	@Override
	public boolean removeFriend(int friendId, int friendCircleId) {
		return userCircleDAO.removeFriend(friendId, friendCircleId);
	}

	@Override
	public FriendCircle getFriendCircle(User user) {
		return userCircleDAO.getFriendCircle(user);
	}

}
