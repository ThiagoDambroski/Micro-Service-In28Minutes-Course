package com.dambroski.restfulwebservicein28Minutes.user;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	public  EntityModel<User>  getUserById(@PathVariable("id") Long id){
		User user = service.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException("id " + id + " not found");
		}
		EntityModel<User> entityModel = EntityModel.of(user);
		
		// Is here there u will put the link u want
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUser());
		entityModel.add(link.withRel("all-users")); // u specify where the link is linked
		
		
		return entityModel;
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
