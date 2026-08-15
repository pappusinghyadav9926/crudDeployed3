package com.example.crudDeployed2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crudDeployed2.entity.Person;
import com.example.crudDeployed2.error.PersonNotFound;
import com.example.crudDeployed2.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

	private final PersonRepository repo;

	public List<Person> getAll() {
		return repo.findAll();
	}

	public Person createPerson(Person pr) {
		return repo.save(pr);
	}

	public Person getOnePerson(Long id) {
		return repo.findById(id).orElseThrow(() -> new PersonNotFound("Person not found  this id : " + id));
	}

}