package com.spring.activitystream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.activitystream.model.User;
import com.spring.activitystream.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Rest Friend Circle";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ResponseEntity addNewUser(@RequestBody User u) {
		if(userService.addUser(u)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/{no}")
	public ResponseEntity<User> getEmployeeByNo(@PathVariable ("no")  int id ) {
		User user = userService.getUserByNo(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		if(users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{no}", method = RequestMethod.POST)
	public ResponseEntity updateUser(@RequestBody User u, @PathVariable("no") int id) {
		if(userService.updateUser(id, u)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}
