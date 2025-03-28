package com.krushna.SpringBootJornalAppUpdate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.krushna.SpringBootJornalAppUpdate.entity.JournalEntry;
import com.krushna.SpringBootJornalAppUpdate.entity.User;
import com.krushna.SpringBootJornalAppUpdate.repository.UserEntryRepository;

@Service
public class UserServiceEntry {
	
	@Autowired
	private UserEntryRepository userrepo;
	
	public User saveEntry(User entry) {
		return userrepo.save(entry);
		
	}
	
	public List<User> getAll(){
		List<User> users =userrepo.findAll();
		return users;
	}
	
	public Optional<User> findById(int myid) {
		return userrepo.findById(myid);
	}
	
	public String deleteById(int myid) {
		userrepo.deleteById(myid);
		return myid + " remove";
	}
	
	public User findByUserName(String userName) {
		return userrepo.findByUserName(userName);
	}
	
}
