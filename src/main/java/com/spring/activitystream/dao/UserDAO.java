package com.spring.activitystream.dao;

import java.util.List;

import com.spring.activitystream.model.User;

public interface UserDAO {
	public boolean addUser(User u);
	public boolean updateUser(int id, User u);
	public User getUserByNo(int id);
	public List<User> getAllUsers();
}
