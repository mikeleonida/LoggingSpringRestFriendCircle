package com.spring.activitystream.service;

import java.util.List;

import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;

public interface UserCircleService {
	public boolean addFriend(int friendId, int friendCircleId);
	public boolean removeFriend(int friendId, int friendCircleId);
	public List<FriendCircle> getFriendCircle(int userId);
}
