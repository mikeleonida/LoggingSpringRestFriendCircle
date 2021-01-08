package com.spring.activitystream.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.activitystream.dao.FriendCircleDAO;
import com.spring.activitystream.model.FriendCircle;
import com.spring.activitystream.model.User;

@Repository
public class FriendCircleDAOImpl implements FriendCircleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addFriendCircle(FriendCircle fc) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(fc);
		tx.commit();
		return true;
	}
	
	@Override
	public List<User> getAllFriends(FriendCircle fc) {
		Session session = sessionFactory.openSession();
		List<FriendCircle> fcList = session
				.createQuery("from FriendCircle f where id=" + fc.getFriendCircleId()).list();
		if (fcList.isEmpty()) {
			return null;
		}
		return ((FriendCircle) fcList.get(0)).getFriends();
	}

	@Override
	public List<FriendCircle> getFriendCirclesLikeName(String name) {
		Session session = sessionFactory.openSession();
		return session.createQuery("from FriendCircle fc where name like '%" + name + "%'").list();
	}

}
