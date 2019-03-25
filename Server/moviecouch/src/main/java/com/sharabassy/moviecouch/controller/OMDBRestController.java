package com.sharabassy.moviecouch.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sharabassy.moviecouch.entity.Movie;

@RestController
@RequestMapping("/omdb")
public class OMDBRestController 
{
	private String apikey = "ead5fbba";
	
	@GetMapping("/search/{searchInput}")
	public List<Movie> searchMovies(@PathVariable String searchInput)
	{
		//https://www.omdbapi.com/?s="hello"&apikey=ead5fbba&type=movie&page=2
		
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("https://www.omdbapi.com/?s=\"%s\"&apikey=%s&type=movie", searchInput, apikey);
		
		ResponseEntity<List<Movie>> response = restTemplate.exchange(
													  url,
													  HttpMethod.GET,
													  null,
													  new ParameterizedTypeReference<List<Movie>>(){});

				
		List<Movie> movies = response.getBody();
	
		return movies;
	}
	
	@GetMapping("/{imdbId}")
	public Movie getMovie(@PathVariable String imdbId)
	{
		//https://www.omdbapi.com/?i=tt1670627&apikey=ead5fbba
		
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("https://www.omdbapi.com/?i=\"%s\"&apikey=%s", imdbId, apikey);
		Movie movie = restTemplate.getForObject(url, Movie.class);
		
		return movie;
	}
}
