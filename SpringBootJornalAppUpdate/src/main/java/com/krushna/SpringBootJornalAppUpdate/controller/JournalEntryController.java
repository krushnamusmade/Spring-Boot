package com.krushna.SpringBootJornalAppUpdate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krushna.SpringBootJornalAppUpdate.entity.JournalEntry;
import com.krushna.SpringBootJornalAppUpdate.entity.User;
import com.krushna.SpringBootJornalAppUpdate.service.JournalServiceEntry;
import com.krushna.SpringBootJornalAppUpdate.service.UserServiceEntry;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	@Autowired
	private JournalServiceEntry service;
	
	@Autowired
	private UserServiceEntry userService;
	
	@GetMapping("/{userName}")
	public ResponseEntity<JournalEntry> getAllJournalEntireisOfUser(@PathVariable String userName){
		User user = userService.findByUserName(userName);
		List<JournalEntry> entry = user.getEntries();
		if(entry != null && !entry.isEmpty()) {
			return new ResponseEntity<JournalEntry>(HttpStatus.OK);
		}else {
			return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/{userName}")
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry,@PathVariable String userName) {
		try {
			service.saveEntry(entry, userName);
			return new ResponseEntity<JournalEntry>(HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<JournalEntry>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/id/{myId}")
	public ResponseEntity<JournalEntry> getSingleEntry(@PathVariable int myId) {
		Optional<JournalEntry> entry = service.findById(myId);
		if(entry.isPresent()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/id/{myId}")
	public ResponseEntity<?> delJournalEntryById(@PathVariable int myId) {
		 service.deleteById(myId);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/id/{myId}")
	public ResponseEntity<JournalEntry> updateId(@PathVariable int myId, @RequestBody JournalEntry entry) {
		return service.updateById(myId, entry);
	}
	
	
}