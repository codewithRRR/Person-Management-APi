package com.NumeroAlpha.Person.Management.API.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.NumeroAlpha.Person.Management.API.dto.Person;
import com.NumeroAlpha.Person.Management.API.exception.GlobalExceptionHandler;
import com.NumeroAlpha.Person.Management.API.exception.PersonNotFoundException;
import com.NumeroAlpha.Person.Management.API.repository.PersonRepository;

@Component
public class PersonService {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@Autowired
	PersonRepository personRepository;

	public ResponseEntity<String> createPerson(Person person) {
		personRepository.save(person);
		return new ResponseEntity<String>("Data saved success", HttpStatus.CREATED);
	}

	public ResponseEntity<Person> getPersonById(int id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Id is not present " + id));
		logger.info("Retrieving person with ID: {}", id);
		return new ResponseEntity<Person>(person, HttpStatus.FOUND);
	}

	public ResponseEntity<String> deletePersonById(int id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isEmpty()) {
			return new ResponseEntity<String>("Id is not present", HttpStatus.NOT_FOUND);

		} else {
			personRepository.delete(person.get());

			return new ResponseEntity<String>("Deleted success", HttpStatus.OK);
		}

	}
}
