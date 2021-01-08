package com.spring.activitystream.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.activitystream.dao.UserDAO;
import com.spring.activitystream.model.User;
import com.spring.activitystream.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean addUser(User u) {
		return userDAO.addUser(u);
	}

	@Override
	public boolean updateUser(int id, User u) {
		u.setUserId(id); // just in case user left it blank in the request body
		return userDAO.updateUser(id, u);
	}

	@Override
	public User getUserByNo(int id) {
		return userDAO.getUserByNo(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	
	// Authentication methods
	@Override
	public boolean login(String username, String password) {
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) &&
					user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean logout(String username) {
		List<User> users = userDAO.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}
	
	
}
