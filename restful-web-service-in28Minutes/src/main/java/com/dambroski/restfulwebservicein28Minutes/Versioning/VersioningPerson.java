package com.dambroski.restfulwebservicein28Minutes.Versioning;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPerson {
	
	@GetMapping("/v1/person")
	public PersonV1 getAllFristVersion() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getAllSecondVersion() {
		return new PersonV2(new Name("bob","Charlie"));
	}

	
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getAllFristVersionOfRequest() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getAllSecondVersionOfRequest() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getAllFristVersionHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getAllSecondVersionHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getAllFristVersionAccept() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getAllSecondVersionAccept() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	

}

