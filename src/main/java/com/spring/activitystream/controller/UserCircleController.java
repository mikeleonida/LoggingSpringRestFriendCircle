package com.spring.activitystream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;
import com.spring.activitystream.service.FriendCircleService;
import com.spring.activitystream.service.UserCircleService;

@RestController
public class UserCircleController {
	
	@Autowired
	private UserCircleService userCircleService;
	
	@RequestMapping(value = "/addfriend", method = RequestMethod.POST)
	public ResponseEntity addFriendToCircle(@RequestParam int userId, @RequestParam int friendCircleId) {
		if(userCircleService.addFriend(userId, friendCircleId)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/removefriend", method = RequestMethod.POST)
	public ResponseEntity removeFriendFromCircle(@RequestParam int userId, @RequestParam int friendCircleId) {
		if(userCircleService.removeFriend(userId, friendCircleId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
