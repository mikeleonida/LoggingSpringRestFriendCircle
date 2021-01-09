package com.spring.activitystream.service;

import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;

public interface UserCircleService {
	public boolean addFriend(int friendId, int friendCircleId);
	public boolean removeFriend(int friendId, int friendCircleId);
	public FriendCircle getFriendCircle(int userId);
}
