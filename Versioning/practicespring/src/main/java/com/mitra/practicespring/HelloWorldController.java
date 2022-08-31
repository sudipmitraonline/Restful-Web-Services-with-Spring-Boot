package com.mitra.practicespring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/welcomesudip")
	public HelloWorldBean HelloWorldBean() {
			return new HelloWorldBean("Hi Sudip");
	}

}
