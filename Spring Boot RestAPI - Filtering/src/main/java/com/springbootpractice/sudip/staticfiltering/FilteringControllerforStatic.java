package com.springbootpractice.sudip.staticfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringControllerforStatic {
	@GetMapping("/static-filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/static-filtering-list")
	public List<SomeBean> retrieveListofBeans() {
		return Arrays.asList(new SomeBean("value1","value2","value3"), 
				new SomeBean("value12","value22","value32"));
	}
}
