package com.spring.activitystream.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.activitystream.dao.UserCircleDAO;
import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;
import com.spring.activitystream.model.UserCircle;

@Repository
public class UserCircleDAOImpl implements UserCircleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addFriend(int userId, int friendCircleId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User friendToAdd = null;
		List users = session.createQuery("from User u where userId=" + userId).list();
		if (!users.isEmpty()) {
			friendToAdd = ((User) users.get(0));
		}
		
		FriendCircle fc = null;
		List friendCircles = session
				.createQuery("from FriendCircle f where friendCircleId="+friendCircleId).list();
		if (!friendCircles.isEmpty()) {
			fc = ((FriendCircle) friendCircles.get(0));
		}
		
		if (friendToAdd == null || fc == null) {
			return false;
		}
		session.save(new UserCircle(friendToAdd, fc));
		tx.commit();
		return true;
	}

	@Override
	public boolean removeFriend(int userId, int friendCircleId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<UserCircle> ucList = session
				.createQuery("from UserCircle uc where userId=" + userId 
				+ " and friendCircleId=" + friendCircleId).list();
		if (!ucList.isEmpty()) {
			return false;
		}
		session.delete(ucList.get(0));
		
		tx.commit();
		return true;
	}

	@Override
	public FriendCircle getFriendCircle(User user) {
		Session session = sessionFactory.openSession();
		List<UserCircle> ucList = session
				.createQuery("from UserCircle uc where userId=" + user.getUserId()).list();
		if (ucList.isEmpty()) {
			return null;
		}
		return ((UserCircle) ucList.get(0)).getFriendCircle();
	}

}
