package com.dambroski.restfulwebservicein28Minutes.user;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dambroski.restfulwebservicein28Minutes.error.UserNotFoundException;

import jakarta.validation.Valid;

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
	public User getUserById(@PathVariable("id") Long id){
		User user = service.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException("id " + id + " not found");
		}
		return user;
	}
	
	@PostMapping("/post")
	public ResponseEntity<User> postUser(@Valid @RequestBody User user) {
		User newUser = service.postUser(user);
		URI location = ServletUriComponentsBuilder
				.fromPath("localhost:8080/users/get/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
	

}
