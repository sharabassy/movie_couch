package com.sharabassy.moviecouch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharabassy.moviecouch.entity.Movie;
import com.sharabassy.moviecouch.entity.User;
import com.sharabassy.moviecouch.exceptionhandling.NotFoundException;
import com.sharabassy.moviecouch.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserRestController 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId)
	{
		User user = userService.getUser(userId);
		if(user==null)
			throw new NotFoundException("User id not found "+userId);
		
		return user;
	}
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user)
	{
		user.setId(0);
		userService.saveUser(user);
		return user;
	}
	
	@PutMapping("/users/{userId}")
	public User addMovieToUser(@PathVariable int userId, @RequestBody Movie movie)
	{
		User user = userService.getUser(userId);
		if(user == null)
			throw new NotFoundException("User id not found "+userId);
		
		movie.setId(0);
		return userService.addMovieToUser(user, movie);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user)
	{
		userService.saveUser(user);
		return user;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId)
	{
		userService.deleteUser(userId);
		
		return "Deleted user with id - " + userId;
	}
}
