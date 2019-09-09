package com.stacksimplify.restservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

@RestController
public class UserController {
	//Autowired the user service
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userService.getAllUser();
			
	}
	//create user method
	//@Request body annotation
	//PostMapping annotation
	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@RequestBody User user,UriComponentsBuilder builder) 
	{
		try
		{
		 userService.createUser(user);
		 HttpHeaders headers= new HttpHeaders();
		 headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
		 return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		}catch(UserExistsException eee)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,eee.getMessage());
		}
	}
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id)
	{
		try
		{
				return userService.getUserById(id);
		}catch(UserNotFoundException ex)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}
	
	}
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable("id") Long id,@RequestBody User user)
	{
		try {
				return userService.updateUserById(id, user);
		}catch(UserNotFoundException exe1)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exe1.getMessage());
		}
		
	}
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id)
	{
		 userService.deleteUserById(id);
	}
	@GetMapping("/users/byusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	
	}
	
}
