package com.sharabassy.moviecouch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharabassy.moviecouch.entity.Movie;
import com.sharabassy.moviecouch.entity.User;
import com.sharabassy.moviecouch.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() 
	{
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int theId) 
	{
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void saveUser(User theUser) 
	{
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public User addMovieToUser(User theUser, Movie theMovie) 
	{
		return userDAO.addMovieToUser(theUser, theMovie);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) 
	{
		userDAO.deleteUser(theId);
	}

}
