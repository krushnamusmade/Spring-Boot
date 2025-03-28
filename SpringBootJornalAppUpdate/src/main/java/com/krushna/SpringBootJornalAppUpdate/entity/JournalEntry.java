package com.krushna.SpringBootJornalAppUpdate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "Journal")
@Getter
@Setter
//@Data
public class JournalEntry {
	
	@Id
	private int id;
	@NonNull
	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User author;
	
	public JournalEntry() {
		// TODO Auto-generated constructor stub
	}

	public JournalEntry(int id, String title, String content,User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = user;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setAuthor(User user) {
		this.author = user;
	}
	
	public User getAuthor() {
		return author;
	}
	
}