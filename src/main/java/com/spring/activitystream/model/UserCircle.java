package com.spring.activitystream.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_circle")
public class UserCircle implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ucId;

	@ManyToOne
    @JoinColumn(name = "userId")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "friendCircleId")
    private FriendCircle friendCircle;
	
	public UserCircle() {
		
	}

	public UserCircle(User user, FriendCircle friendCircle) {
		super();
		this.user = user;
		this.friendCircle = friendCircle;
	}

	public int getUcId() {
		return ucId;
	}

	public void setUcId(int ucId) {
		this.ucId = ucId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FriendCircle getFriendCircle() {
		return friendCircle;
	}

	public void setFriendCircle(FriendCircle friendCircle) {
		this.friendCircle = friendCircle;
	}
	
	
	
}
