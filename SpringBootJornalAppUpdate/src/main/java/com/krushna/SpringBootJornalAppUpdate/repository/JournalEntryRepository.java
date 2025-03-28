package com.krushna.SpringBootJornalAppUpdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krushna.SpringBootJornalAppUpdate.entity.JournalEntry;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer>{

}
