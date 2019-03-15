package com.sharabassy.moviecouch.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserMovieId implements Serializable
{
	//for reference check "https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/"
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="movie_id")
	private int movieId;
	
	//Constructors
	
	public UserMovieId() {}

	public UserMovieId(int userId, int movieId) 
	{
		this.userId = userId;
		this.movieId = movieId;
	}

	//Getters & Setters
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	//The @Embeddable type must override the default equals and hashCode methods based on the two Primary Key identifier values.
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		
		if(o == null || getClass() != o.getClass()) 
			return false;
		
		UserMovieId that = (UserMovieId)o;
		return  Objects.equals(userId, that.userId) && 
				Objects.equals(movieId, that.movieId);	
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(userId,movieId);
	}
	
}
