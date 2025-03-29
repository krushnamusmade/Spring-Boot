package com.krushna.springBootJournalApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.krushna.springBootJournalApp.entity.JournalEntry;
import com.krushna.springBootJournalApp.repository.JournalEntryRepository;

@Service
public class JournalServiceEntry {
	
	@Autowired
	private JournalEntryRepository repo;
	
	public void saveEntry(JournalEntry entry) {
		repo.save(entry);
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
			// the error gettitle this are becuse the code not run 
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
