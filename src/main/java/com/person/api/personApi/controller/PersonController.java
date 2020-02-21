package com.person.api.personApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.person.api.personApi.exception.ResourceNotFoundException;
import com.person.api.personApi.model.Person;
import com.person.api.personApi.repository.PersonRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/person")
@Api(value="personApi", description="Operations pertaining to person data management")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	// get all person
	@ApiOperation(value = "View a list of available persons", response = Iterable.class)
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/all")
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	// create a person
	@PostMapping("/addPerson")
	@ApiOperation(value = "Add a person")
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST, produces = "application/json")
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	// get a person using id
	@ApiOperation(value = "Search a person with an ID", response = Person.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not Found for the id" + id));
		return ResponseEntity.ok().body(person);
	}

	// update a person
	@ApiOperation(value = "Update a person")
	@RequestMapping(value = "/updatePerson/{id}", method = RequestMethod.PUT, produces = "application/json")
	@PutMapping("updatePerson/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") long id, @RequestBody Person personDetails)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not Found for the id" + id));
		person.setFirst_name(personDetails.getFirst_name());
		person.setLast_name(personDetails.getLast_name());
		person.setAge(personDetails.getAge());
		person.setFavourite_colour(personDetails.getFavourite_colour());
		person.setHobby(personDetails.getHobby());
		personRepository.save(person);
		return ResponseEntity.ok().body(person);
	}

	// delete a person
	@ApiOperation(value = "Delete a person")
	@RequestMapping(value = "/deletePerson/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@DeleteMapping("deletePerson/{id}")
	public ResponseEntity deletePerson(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not Found for the id" + id));
		personRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
