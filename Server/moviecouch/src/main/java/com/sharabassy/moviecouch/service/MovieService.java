package com.sharabassy.moviecouch.service;

import java.util.List;

import com.sharabassy.moviecouch.entity.Movie;

public interface MovieService 
{
	public List<Movie> getMovies();
	
	public Movie getMovie(int movieId);
	
	public void saveMovie(Movie movie);
}
