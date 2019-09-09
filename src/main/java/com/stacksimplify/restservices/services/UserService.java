package com.stacksimplify.restservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  //Autowired user repository
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser(){
		
		return userRepository.findAll();
				
	}
	public User createUser(User user) throws UserExistsException {
		User exitingUser=userRepository.findByUsername(user.getUsername());
		if(exitingUser != null)
		{
			throw new UserExistsException("User already exists in the repository");
		}
		return userRepository.save(user);
		
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException
	{
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User not fouding in the repository");
		return user;
		
	}
	public User updateUserById(Long id,User user) throws UserNotFoundException
	{
		
		Optional<User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not fouding in the repository,provide the correct user id");
		}
		user.setId(id);
		return userRepository.save(user);
	}
	public void deleteUserById(Long id) 
	{
		Optional<User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not fouding in the repository");
		}
			userRepository.deleteById(id);
		
	}
	public User getUserByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
}
