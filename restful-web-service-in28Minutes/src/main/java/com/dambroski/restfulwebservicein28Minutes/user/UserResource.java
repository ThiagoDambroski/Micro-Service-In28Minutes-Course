package com.dambroski.restfulwebservicein28Minutes.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	UserDaoService service;
	
	
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return service.getAll();
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return service.getUserById(id);
	}
	
	@PostMapping("/post")
	public User postUser(@RequestBody User user) {
		return service.postUser(user);
	}
	

}
