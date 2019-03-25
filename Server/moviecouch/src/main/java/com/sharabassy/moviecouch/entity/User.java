package com.sharabassy.moviecouch.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.ALL,
	           orphanRemoval = true,
	           fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<UserMovie> movies = new ArrayList<>();
	
	//Constructors
	
	public User() {}

	public User(String username, String password, String email) 
	{
		this.username = username;
		this.password = password;
		this.email = email;
	}

	//Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserMovie> getMovies() {
		return movies;
	}

	public void setMovies(List<UserMovie> movies) {
		this.movies = movies;
	}
	
	//Convenience Methods
	
	public void addMovie(Movie movie)
	{
		UserMovie userMovie = new UserMovie(this, movie);
		movies.add(userMovie);
	}
	
	public boolean hasMovie(Movie movie)
	{
		for(UserMovie userMovie:movies)
		{
			String imdbId = userMovie.getMovie().getImdbId();
			String newImdbId = movie.getImdbId();
			if(imdbId!=null && newImdbId!=null && imdbId.equalsIgnoreCase(newImdbId));
				return true;
		}
		
		return false;
	}
	
	public void removeMovie(Movie movie)
	{
		for(Iterator<UserMovie> iterator = movies.iterator(); iterator.hasNext();)
		{
			UserMovie userMovie = iterator.next();
			if(userMovie.getMovie().equals(movie) && userMovie.getUser().equals(this))
			{
				iterator.remove();
				userMovie.setMovie(null);
				userMovie.setUser(null);
			}
		}
	}
	
	
	
	
	

}
