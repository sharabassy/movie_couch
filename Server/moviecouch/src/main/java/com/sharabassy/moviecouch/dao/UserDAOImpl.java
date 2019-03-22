package com.sharabassy.moviecouch.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharabassy.moviecouch.entity.Movie;
import com.sharabassy.moviecouch.entity.User;

@Repository
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() 
	{
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//shaarabassy query by entity class name not table name
		Query<User> query = currentSession.createQuery("from User order by username",User.class);
		List<User> users = query.getResultList();
		
		return users;
	}

	@Override
	public User getUser(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, theId);
		
		return user;
	}

	@Override
	public void saveUser(User theUser) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public User addMovieToUser(User theUser, Movie theMovie)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		theUser.addMovie(theMovie);
		currentSession.saveOrUpdate(theUser);
		
		return theUser;

	}

	@Override
	public void deleteUser(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", theId);
		
		query.executeUpdate();
	}
	
	

}
