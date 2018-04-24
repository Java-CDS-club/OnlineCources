package com.oc.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping("/getStaticFilteredUser")
	public StaticFilteredUser getStaticFilteredUser() {
		return new StaticFilteredUser("Suhail", "Ahamad", "Mansoori");
		
	}
	
	@GetMapping("/getDynamicFilteredUser/{prod}")
	public MappingJacksonValue getDynamicFilteredUser(@PathVariable String prod) {
		
		DynamicFilteredUser dfu = new DynamicFilteredUser("Suhail","Ahamad", "Mansoori");
		MappingJacksonValue mjv = new MappingJacksonValue(dfu);
		
		PropertyFilter pf = null;
		if("f".equalsIgnoreCase(prod)) {
			pf = SimpleBeanPropertyFilter.filterOutAllExcept("firstName");
		}else if("fm".equalsIgnoreCase(prod)){
			pf = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");
		}else{
			pf = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName", "middleName");
		}
		
		mjv.setFilters(new SimpleFilterProvider().addFilter("filterLastName", pf));
		return mjv;
	}
	
}
