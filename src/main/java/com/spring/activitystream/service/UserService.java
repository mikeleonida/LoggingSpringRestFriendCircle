package com.spring.activitystream.service;

import java.util.List;

import com.spring.activitystream.model.User;

public interface UserService {
	public boolean addUser(User u);
	public boolean updateUser(int id, User u);
	public User getUserByNo(int id);
	public List<User> getAllUsers();
	
	public boolean login(String username, String password);
	public boolean logout(String username);
}
