package com.krushna.SpringBootJornalAppUpdate.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.krushna.SpringBootJornalAppUpdate.entity.JournalEntry;
import com.krushna.SpringBootJornalAppUpdate.entity.User;
import com.krushna.SpringBootJornalAppUpdate.repository.JournalEntryRepository;


@Service
public class JournalServiceEntry {
	
	@Autowired
	private JournalEntryRepository repo;
	@Autowired
	private UserServiceEntry userService;
	
	public void saveEntry(JournalEntry entry,String userName) {
		User user = userService.findByUserName(userName);
		JournalEntry saved = repo.save(entry);
		user.getEntries().add(saved);
		userService.saveEntry(user);
	}
	
	public List<JournalEntry> getAll(){
		return repo.findAll();
	}
	
	public Optional<JournalEntry> findById(int myid) {
		return repo.findById(myid);
	}
	
	public String deleteById(int myid) {
		repo.deleteById(myid);
		return myid + " remove";
	}
	
	public ResponseEntity<JournalEntry> updateById(int id,JournalEntry entry) {
		JournalEntry old = repo.findById(id).orElse(null);
		if(old != null) {
			// the error gettitle this are because the code not run 
			//old.setId(entry.getId() != null ? entry.getId() : old.getId());
			old.setTitle(entry.getTitle() != null  ? entry.getTitle() : old.getTitle());
			old.setContent(entry.getContent() != null  ? entry.getContent() : old.getContent());
			repo.save(old);
			return new ResponseEntity<JournalEntry>(HttpStatus.OK);
		}else {
			return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
		}
		
	}
}
