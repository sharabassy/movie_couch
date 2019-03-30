package com.sharabassy.moviecouch.service;

import java.util.List;

import com.sharabassy.moviecouch.entity.Movie;
import com.sharabassy.moviecouch.entity.User;

public interface UserService 
{
	public List<User>getUsers();
	
	public User getUser(int theId);
	
	public void saveUser(User theUser);
	
	public void deleteUser(int theId);

	public User addMovieToUser(User theUser, Movie theMovie);
	
	public User removeMovieFromUser(User user,Movie movie);
}
