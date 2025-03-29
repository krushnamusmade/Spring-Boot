//package com.krushna.springBootJournalApp.Controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.krushna.springBootJournalApp.entity.JournalEntry;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//	private Map<Integer,JournalEntry> journalEntries = new HashMap<>();
//	
//	@GetMapping
//	public List<JournalEntry> getAll(){
//		return new ArrayList<>(journalEntries.values());
//	}
//	
//	@PostMapping
//	public String createEntry(@RequestBody JournalEntry entry) {
//		journalEntries.put(entry.getId(), entry);
//		return "Ok";
//	}
//	
//	@GetMapping("/id/{myId}")
//	public JournalEntry getSingleEntry(@PathVariable int myId) {
//		return journalEntries.get(myId);
//	}
//	
//	@DeleteMapping("/id/{myId}")
//	public String delJournalEntryById(@PathVariable int myId) {
//		journalEntries.remove(myId);
//		return "remove id " + myId;
//	}
//	
//	@PutMapping("/id/{myId}")
//	public JournalEntry updateId(@PathVariable int myId, @RequestBody JournalEntry entry) {
//		return journalEntries.put(myId, entry);
//	}
//	
//	
//}
