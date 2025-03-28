package com.krushna.SpringBootJornalAppUpdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krushna.SpringBootJornalAppUpdate.entity.User;

public interface UserEntryRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);
	
}
