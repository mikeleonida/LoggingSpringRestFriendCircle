package com.spring.activitystream.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "friendcircle")
public class FriendCircle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int friendCircleId;

	@Column(nullable = false)
	private String name;
	
//	<many-to-one name="emp" class="onetomanypack.Employee" fetch="select">
//	<column name="EMPLOYEE_ID" not-null="true" />
//</many-to-one>

//	@OneToMany
//	@Column(name="USER_ID", nullable=false)
//	private List<User> friends;

	public FriendCircle() {
		
	}

	public FriendCircle(String name) {
		super();
		this.name = name;
	}

	public int getFriendCircleId() {
		return friendCircleId;
	}

	public void setFriendCircleId(int friendCircleId) {
		this.friendCircleId = friendCircleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
