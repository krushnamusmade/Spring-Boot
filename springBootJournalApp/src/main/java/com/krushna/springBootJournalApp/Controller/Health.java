package com.krushna.springBootJournalApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

	@GetMapping("/health-check")
	public String checkHealth() {
		return "Ok";
	}
}
