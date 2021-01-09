package com.spring.activitystream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.activitystream.model.User;
import com.spring.activitystream.service.UserService;

@RestController
public class UserAuthController {
	
	@Autowired
	private UserService userService;	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity loginUser(@RequestParam ("username") String username,
			@RequestParam ("password") String password) {
		if(userService.login(username, password)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity logoutUser(@RequestParam ("username") String username) {
		if(userService.logout(username)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
}
