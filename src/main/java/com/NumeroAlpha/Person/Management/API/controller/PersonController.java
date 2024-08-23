package com.NumeroAlpha.Person.Management.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NumeroAlpha.Person.Management.API.dto.Person;
import com.NumeroAlpha.Person.Management.API.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonService service;

	@PostMapping("/persons")
	public ResponseEntity<String> addPerson(@RequestBody Person person) {
		return service.createPerson(person);
	}

	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> fetchId(@PathVariable int id) {
		return service.getPersonById(id);
	}

	@DeleteMapping("/persons/{id}")
	public ResponseEntity<String> deleteId(@PathVariable int id) {
		return service. deletePersonById(id);
	}
}
