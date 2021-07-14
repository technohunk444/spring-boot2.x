package com.rab3tech.rest.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPage {
	
	@GetMapping("/")
	public String landingPage() {
		return "redirect:/swagger-ui.html";
	}

}
