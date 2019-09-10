package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	//getAllOrders for a user
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException
	{
		
		java.util.Optional<User> userOptional= userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User not fouding in the repository");
		return userOptional.get().getOrders();
	}
	
	//create order for the user
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId,@RequestBody Order order) throws UserNotFoundException
	{
		Optional<User> userOptional=userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User not fouding in the repository");
	
		User user=userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
			
		
	}
	@GetMapping("/{userId}/orders/{orderId}")
	public Optional<Order> getOrderByOrderId(@PathVariable Long orderId) throws OrderNotFoundException
	{
		Optional<Order> orderOptional= orderRepository.findById(orderId);
		if(!orderOptional.isPresent())
			throw new OrderNotFoundException("Order not fouding in the repository");
		
			return orderRepository.findById(orderId);
		
	}
	
	
	
	
	
	

}
