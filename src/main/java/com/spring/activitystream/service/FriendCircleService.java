package com.spring.activitystream.service;

import java.util.List;

import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;

public interface FriendCircleService {
	public boolean addFriendCircle(FriendCircle fc);
	public List<User> getAllFriends(FriendCircle fc);
	public List<FriendCircle> getFriendCirclesLikeName(String name);
}
