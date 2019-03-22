package com.sharabassy.moviecouch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharabassy.moviecouch.entity.Movie;
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
	
}
