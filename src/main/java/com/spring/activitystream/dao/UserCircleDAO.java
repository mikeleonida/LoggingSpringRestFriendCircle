package com.spring.activitystream.dao;

import java.util.List;

import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;

public interface UserCircleDAO {
	public boolean addFriend(int friendId, int friendCircleId);
	public boolean removeFriend(int friendId, int friendCircleId);
	public List<FriendCircle> getFriendCircle(int userId);
}
