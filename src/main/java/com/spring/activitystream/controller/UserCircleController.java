package com.spring.activitystream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/addfriend", method = RequestMethod.PUT)
	public ResponseEntity addFriendToCircle(@RequestParam int userId, @RequestParam int friendCircleId) {
		if(userCircleService.addFriend(userId, friendCircleId)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/removefriend", method = RequestMethod.DELETE)
	public ResponseEntity removeFriendFromCircle(@RequestParam int userId, @RequestParam int friendCircleId) {
		if(userCircleService.removeFriend(userId, friendCircleId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/friendcircle/{no}")
	public ResponseEntity<List<FriendCircle>> getCircleByUserId(@PathVariable ("no") int userId) {
		List<FriendCircle> fc = userCircleService.getFriendCircle(userId);
		if (fc != null) {
			return new ResponseEntity<>(fc, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
