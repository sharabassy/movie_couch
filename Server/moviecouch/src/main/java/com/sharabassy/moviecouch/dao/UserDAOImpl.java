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
	public void saveUser(User user) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}

	@Override
	public User addMovieToUser(User user, Movie movie)
	{		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//1- Movie is not in DB?
		Movie existingMovie = (Movie)currentSession.bySimpleNaturalId(Movie.class).load(movie.getImdbId());
		//TODO naturalId did not work on an existing record,need to test on a newly entered record
		if(existingMovie != null)
			movie = existingMovie;
		
		//2- Movie is not in user movie list?
		//TODO will have to check on the other attributes of userMovie as well which are not yet added like scheduled date for ex
		if(!user.hasMovie(movie))
		{
			user.addMovie(movie);
			currentSession.saveOrUpdate(user);
		}		
		
		return user;

	}

	@Override
	public void deleteUser(int userId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", userId);
		
		query.executeUpdate();
	}
	
	

}
