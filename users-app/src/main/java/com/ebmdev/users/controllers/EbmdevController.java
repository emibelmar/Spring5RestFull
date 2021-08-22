package com.ebmdev.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class EbmdevController {

	
	@GetMapping
	public String helloWorld() {
		return "Hello World!";
	}
}
