package com.springbootpractice.sudip.dynamicfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		SomeBean1 someBean1 = new SomeBean1("value1","value2","value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean1);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveListofBeans() {
		List<SomeBean1> list = Arrays.asList(new SomeBean1("value1","value2","value3"), 
				new SomeBean1("value12","value22","value32"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}
}
