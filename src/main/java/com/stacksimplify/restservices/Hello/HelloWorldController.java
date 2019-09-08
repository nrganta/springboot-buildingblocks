package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	//simple method
	//URI-helloWorld
	//GET 
	//@RequestMapping(method=RequestMethod.GET,path="/helloWorld")
	@GetMapping("/helloWorld1")
	public String helloWorld()
	{
		return "HelloWorld1 from Nag";
	}
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean()
	{
		return new UserDetails("Kalyan","Reddy","Hyderabad");
	}
}
