package com.sharabassy.moviecouch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharabassy.moviecouch.entity.Movie;
import com.sharabassy.moviecouch.exceptionhandling.NotFoundException;
import com.sharabassy.moviecouch.service.MovieService;

@RestController
@RequestMapping("/movieapi")
public class MovieRestController
{
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public List<Movie> getMovies()
	{
		return movieService.getMovies();
	}
	
	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable int movieId)
	{
		Movie movie  = movieService.getMovie(movieId);
		if(movie == null)
			throw new NotFoundException("Movie not found id " + movieId);
		
		return movie;
	}
	
	
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie movie)
	{
		movie.setId(0);
		movieService.saveMovie(movie);
		
		return movie;
	}
	
}
