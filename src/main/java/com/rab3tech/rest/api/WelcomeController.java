package com.rab3tech.rest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "WelcomeController", description = "REST APIs related to Test Entity!!!!")
public class WelcomeController {
	
	@GetMapping("/hello")
	public String hekl(){
		return "Hello Swagger!";
	}

}
