package com.krushna.SpringBootJornalAppUpdate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krushna.SpringBootJornalAppUpdate.entity.User;
import com.krushna.SpringBootJornalAppUpdate.service.UserServiceEntry;


@RestController
@RequestMapping("/user")
public class UserEntryController {

	@Autowired
	private UserServiceEntry service;
	
	@GetMapping
	public List<User> getAllUser(){
		return service.getAll();
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		service.saveEntry(user);
	}
	
	@PutMapping("/{username}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String username){
		User userId = service.findByUserName(username);
		if(userId != null) {
			userId.setUserName(user.getUserName());
			userId.setPassword(user.getPassword());
			service.saveEntry(userId);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
}