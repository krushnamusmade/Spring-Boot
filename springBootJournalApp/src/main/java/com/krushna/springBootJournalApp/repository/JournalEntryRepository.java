package com.krushna.springBootJournalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krushna.springBootJournalApp.entity.JournalEntry;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer>{
	
	

}
