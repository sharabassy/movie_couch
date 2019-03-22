package com.sharabassy.moviecouch.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharabassy.moviecouch.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getMovies() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Movie> query = currentSession.createQuery("from Movie order by title", Movie.class);
		List<Movie> movies = query.getResultList();
		
		return movies;
	} 
	
	

}
