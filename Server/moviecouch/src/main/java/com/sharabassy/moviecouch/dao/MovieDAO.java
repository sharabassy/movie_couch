package com.sharabassy.moviecouch.dao;

import java.util.List;

import com.sharabassy.moviecouch.entity.Movie;

public interface MovieDAO 
{
	
	public List<Movie> getMovies();
	
	public Movie getMovie(int movieId);
	
	public void saveMovie(Movie movie);
}
