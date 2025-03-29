package com.krushna.springBootJournalApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krushna.springBootJournalApp.entity.JournalEntry;
import com.krushna.springBootJournalApp.service.JournalServiceEntry;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

	@Autowired
	private JournalServiceEntry service;
	
	
	@GetMapping
	public ResponseEntity<JournalEntry> getAll(){
		List<JournalEntry> entry = service.getAll();
		if(entry != null && !entry.isEmpty()) {
			return new ResponseEntity<JournalEntry>(HttpStatus.OK);
		}else {
			return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry) {
		try {
			service.saveEntry(entry);
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
