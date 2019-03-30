package com.sharabassy.moviecouch.dao;

import java.util.List;

import com.sharabassy.moviecouch.entity.Movie;
import com.sharabassy.moviecouch.entity.User;

public interface UserDAO 
{
	public List<User>getUsers();
	
	public User getUser(int id);
	
	public void saveUser(User user);
	
	public void deleteUser(int id);

	public User addMovieToUser(User user, Movie movie);
	
	public User removeMovieFromUser(User user, Movie movie);
}
