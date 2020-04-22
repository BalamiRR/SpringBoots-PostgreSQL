package com.fuatkara.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fuatkara.dao.PersonDao;
import com.fuatkara.model.Person;

@Service	 
public class PersonService {
	//Service class'inda sadece isimize yarayan methodlari burada toparlayip
	//Controllerda calisitiriyoruz.
	private final PersonDao personDao;

	//PersonService Constructor, PersonDao yu autowired yapiyoruz.
	//FakePersonDataAccess deki PersonDao yu cagriyor.
	@Autowired  
	public PersonService(@Qualifier("postgres") PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
	
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person person) {
		return personDao.updatePersonById(id, person);
	}
	
}