package com.oc.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	//URI Versioning
	@GetMapping("/V1/data")
	public String getURIVersion1() {
		return "URI Version1";
	}
	
	@GetMapping("/V2/data")
	public String getURIVersion2() {
		return "URI Version2";
	}
	
	//Parameter Versioning
	@GetMapping(value="/data", params="version=1" )
	public String getPramVersion1() {
		return "Param Version1";
	}
	
	@GetMapping(value="/data",  params="version=2")
	public String getPramVersion2() {
		return "Param Version2";
	}
	
	//Header Versioning
	@GetMapping(value="/data", headers="X-API-VERSION=1" )
	public String getHeaderVersion1() {
		return "Header Version1";
	}
	
	@GetMapping(value="/data",  headers="X-API-VERSION=2")
	public String getHeaderVersion2() {
		return "Header Version2";
	}
	
	//Produces Versioning
	@GetMapping(value="/data", produces= {"application/v1+xml","application/v1+json"} )
	public Version getProducesVersion1() {
		return new Version("Produces Version1");
	}
	
	@GetMapping(value="/data",  produces= {"application/v2+xml","application/v2+json"})
	public Version getProducesVersion2() {
		return new Version("Produces Version2");
	}
}
