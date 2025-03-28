package com.krushna.SpringBootJornalAppUpdate.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	@NonNull
	private String userName;
	@NonNull
	private String password;
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<JournalEntry> entries = new ArrayList<JournalEntry>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, @NonNull String userName, @NonNull String password, List<JournalEntry> entries) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.entries = entries;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public List<JournalEntry> getEntries() {
		return entries;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEntries(List<JournalEntry> entries) {
		this.entries = entries;
	}
	
	
	
	
}
