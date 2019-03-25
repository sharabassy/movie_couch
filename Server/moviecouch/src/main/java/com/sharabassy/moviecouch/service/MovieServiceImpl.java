package com.sharabassy.moviecouch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharabassy.moviecouch.dao.MovieDAO;
import com.sharabassy.moviecouch.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService 
{
	@Autowired
	MovieDAO movieDAO;
	
	@Override
	@Transactional
	public List<Movie> getMovies() 
	{
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public Movie getMovie(int movieId) 
	{
		return movieDAO.getMovie(movieId);
	}

	@Override
	@Transactional
	public void saveMovie(Movie movie) 
	{
		movieDAO.saveMovie(movie);		
	}

}
