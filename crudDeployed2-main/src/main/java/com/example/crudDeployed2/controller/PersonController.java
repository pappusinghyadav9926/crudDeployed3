package com.example.crudDeployed2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudDeployed2.entity.Person;
import com.example.crudDeployed2.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
@CrossOrigin("*")
public class PersonController {

	private final PersonService service;

	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@PostMapping
	public ResponseEntity<Person> createPerons(@RequestBody Person pr) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(pr));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getOnePerson(@RequestParam Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOnePerson(id));
	}
}