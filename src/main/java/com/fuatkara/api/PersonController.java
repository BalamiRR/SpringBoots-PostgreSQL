package com.fuatkara.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuatkara.model.Person;
import com.fuatkara.service.PersonService;

@RequestMapping(value="/api")
@RestController
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	//personService ama void olarak 
	//localhost:8080/api/v1/person
	@PostMapping(value="/v1/person")
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		//Name bos olamaz
		//Person sinifindada Json property olarak belirledik.
		personService.addPerson(person);
	}	
	
	@GetMapping(value="/v1/person")
	public List<Person> getAllPeople(){
		return personService.getAllPeople();
	}

	@GetMapping(path = "/v1/person/{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		//Bu @PathVariable id'mizi aliyor, UUID'ye ceviriyor.
		return personService.getPersonById(id)
				    .orElse(null);
	}
	
	@DeleteMapping(path = "/v1/person/{id}")
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
	
	@PutMapping(path = "/v1/person/{id}")
	public void updatePersonById(@PathVariable("id") UUID id,
								 @Valid @NonNull @RequestBody Person personToUpdate) {
		//name bos olamaz
		personService.updatePerson(id, personToUpdate);
	}
	
}