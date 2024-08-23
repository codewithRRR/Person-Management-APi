package com.NumeroAlpha.Person.Management.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NumeroAlpha.Person.Management.API.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
