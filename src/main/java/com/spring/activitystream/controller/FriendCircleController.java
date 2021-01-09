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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;
import com.spring.activitystream.service.FriendCircleService;

@RestController
public class FriendCircleController {
	
	@Autowired
	private FriendCircleService fcService;
	
	@RequestMapping(value = "/addfriendcircle", method = RequestMethod.PUT)
	public ResponseEntity addNewUser(@RequestBody FriendCircle f) {
		if(fcService.addFriendCircle(f)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/friendcircles")
	public ResponseEntity<List<FriendCircle>> getFriendCirclesByName(@RequestParam ("name") String name) {
		List<FriendCircle> friendCircles = fcService.getFriendCirclesLikeName(name);
		if (friendCircles == null || friendCircles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(friendCircles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/friends", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getFriendsInCircle(@RequestBody FriendCircle f) {
		List<User> friends = fcService.getAllFriends(f);
		if (friends==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(friends, HttpStatus.OK);
	}
}
