package com.challenge.project.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.project.model.Contact;
import com.challenge.project.model.Person;
import com.challenge.project.repository.ContactRepository;
import com.challenge.project.repository.PersonRepository;
import com.challenge.project.service.PersonService;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonService personService;
	

	@GetMapping("/{code}")
	public ResponseEntity<Person> searchCode(@PathVariable Long code) {
		Person person = personRepository.findByCode(code);
		return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<Page<Person>> listPerson(Pageable pageable) {

		return new ResponseEntity<Page<Person>>(personService.listPerson(pageable), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
		Person personSave = personService.savePerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(personSave);

	}

	@PutMapping
	public ResponseEntity<Person> update(@Valid @RequestBody Person person) {
		Person personSave = personService.updatePerson(person);
		return ResponseEntity.ok(personSave);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		Person person = personRepository.findByCode(id);
		personRepository.delete(person);
	}

}
