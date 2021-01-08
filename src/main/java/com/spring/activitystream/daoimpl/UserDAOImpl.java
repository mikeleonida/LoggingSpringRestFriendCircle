package com.spring.activitystream.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.activitystream.dao.UserDAO;
import com.spring.activitystream.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		return true;
	}

	@Override
	public boolean updateUser(int id, User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
		return true;
	}

	@Override
	public User getUserByNo(int id) {
		Session session = sessionFactory.openSession();
		//return (User) session.get(User.class, id);
		List users = session.createQuery("from User u where userId=" + id).list();
		if (users.isEmpty()) {
			return null;
		}
		return ((User) users.get(0));
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from User u").list();
	}
	
}
