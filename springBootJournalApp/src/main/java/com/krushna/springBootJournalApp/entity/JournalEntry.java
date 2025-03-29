package com.krushna.springBootJournalApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "journalentry")
@Getter
@Setter
@Data
public class JournalEntry {
	
	@Id
	private int id;
	private String title;
	private String content;
	
//	public JournalEntry() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public JournalEntry(int id, String title, String content) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.content = content;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
	
	

}
