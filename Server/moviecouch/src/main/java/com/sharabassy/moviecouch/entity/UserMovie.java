package com.sharabassy.moviecouch.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="user_movie")
public class UserMovie 
{
	
	@EmbeddedId
	private UserMovieId id;
	
	@ManyToOne( fetch = FetchType.EAGER,
				cascade = { CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH})
	@MapsId("userId")
	@JsonBackReference
	private User user;
	
	@ManyToOne( fetch = FetchType.EAGER,
				cascade = { CascadeType.DETACH,
							CascadeType.MERGE,
							CascadeType.PERSIST,
							CascadeType.REFRESH})
	@MapsId("movieId")
	private Movie movie;
	
	//TODO : put here the extra columns + add their getters and setters & add them to constructor
	
	// Constructors
	public UserMovie() {}

	public UserMovie(User user, Movie movie) 
	{
		this.user = user;
		this.movie = movie;
		this.id = new UserMovieId(user.getId(), movie.getId());
	}

	//Getters & Setters
	public UserMovieId getId() {
		return id;
	}

	public void setId(UserMovieId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
		
	
	
}
