package com.sharabassy.moviecouch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
		List<Movie> movieSearchList = new ArrayList<Movie>();
		RestTemplate restTemplate = new RestTemplate();
		
		String url = String.format("https://www.omdbapi.com/?s=\"%s\"&apikey=%s&type=movie", searchInput, apikey);
		ObjectNode rootNode = restTemplate.getForObject(url, ObjectNode.class);
		String response = rootNode.path("Response").asText();
		
		if(response.equals("True"))
		{
			JsonNode searchNode = rootNode.path("Search");
			if(!searchNode.isMissingNode())
			{				
				for(JsonNode movieNode : searchNode)
				{
					Movie tmpMovie = createMovieObjectFromJson(movieNode.deepCopy());
					movieSearchList.add(tmpMovie);
				}
			}
		}
	
		return movieSearchList;
	}
	
	@GetMapping("/{imdbId}")
	public Movie getMovieByImdbId(@PathVariable String imdbId)
	{
		//https://www.omdbapi.com/?i=tt1670627&apikey=ead5fbba
		
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("https://www.omdbapi.com/?i=%s&apikey=%s", imdbId, apikey).replace("\"", "");
		ObjectNode node = restTemplate.getForObject(url, ObjectNode.class);
		Movie movie = createMovieObjectFromJson(node);
		
		return movie;
	}
	
	private Movie createMovieObjectFromJson(ObjectNode node)
	{
		Movie tempMovie = new Movie();
		
		if(node.has("imdbID"))
			tempMovie.setImdbId(node.get("imdbID").asText());
		if(node.has("Title"))
			tempMovie.setTitle(node.get("Title").asText());
		if(node.has("Type"))
			tempMovie.setType(node.get("Type").asText());
		if(node.has("Poster"))
			tempMovie.setPoster(node.get("Poster").asText());
		if(node.has("Year"))
			tempMovie.setYear(node.get("Year").asText());
		if(node.has("Rated"))
			tempMovie.setRated(node.get("Rated").asText());
		if(node.has("Released"))
			tempMovie.setReleased(node.get("Released").asText());
		if(node.has("Runtime"))
			tempMovie.setRuntime(node.get("Runtime").asText());
		if(node.has("Genre"))
			tempMovie.setGenre(node.get("Genre").asText());
		if(node.has("Director"))
			tempMovie.setDirector(node.get("Director").asText());
		if(node.has("Writer"))
			tempMovie.setWriter(node.get("Writer").asText());
		if(node.has("Actors"))
			tempMovie.setActors(node.get("Actors").asText());
		if(node.has("Plot"))
			tempMovie.setPlot(node.get("Plot").asText());
		if(node.has("Language"))
			tempMovie.setLanguage(node.get("Language").asText());
		if(node.has("Country"))
			tempMovie.setCountry(node.get("Country").asText());
		if(node.has("Awards"))
			tempMovie.setAwards(node.get("Awards").asText());
		if(node.has("Metascore"))
			tempMovie.setMetascore(node.get("Metascore").asText());
		if(node.has("imdbRating"))
			tempMovie.setImdbRating(node.get("imdbRating").asText());
		if(node.has("imdbVotes"))
			tempMovie.setImdbVotes(node.get("imdbVotes").asText());
		if(node.has("DVD"))
			tempMovie.setDvd(node.get("DVD").asText());
		if(node.has("BoxOffice"))
			tempMovie.setBoxOffice(node.get("BoxOffice").asText());
		if(node.has("Production"))
			tempMovie.setProduction(node.get("Production").asText());
		if(node.has("Website"))
			tempMovie.setWebsite(node.get("Website").asText());
		
		return tempMovie; 
	}
}
