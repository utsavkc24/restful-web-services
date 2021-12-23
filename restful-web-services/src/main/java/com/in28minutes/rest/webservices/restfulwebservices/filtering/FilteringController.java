package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	// field1, field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		return extractedMappingJacksonValue(null, someBean, SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2"));
	}

	// field2, field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value11", "value22", "value33"));

		return extractedMappingJacksonValue(null, list,
				SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field2"));
	}

	private MappingJacksonValue extractedMappingJacksonValue(List<SomeBean> list, Object ob,
			SimpleBeanPropertyFilter filter) {
		MappingJacksonValue mapping = null;
		if (ob != null) {
			mapping = new MappingJacksonValue(ob);
		} else {
			mapping = new MappingJacksonValue(list);
		}
		mapping.setFilters(extractedFilters(filter));
		return mapping;
	}

	private FilterProvider extractedFilters(SimpleBeanPropertyFilter filter) {
		return new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	}
}
