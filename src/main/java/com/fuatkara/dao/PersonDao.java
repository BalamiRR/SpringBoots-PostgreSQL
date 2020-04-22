package com.fuatkara.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fuatkara.model.Person;

public interface PersonDao {
		//Iki methodumuz var, insertPerson bize verilen id'le ekleyemeye izin veriyor. 
		int insertPerson(UUID id, Person person);
		
		//Alttaki ise id'siz ekleyebilicez, cunku randomlu veriyor.
		default int insertPerson(Person person) {
			UUID id = UUID.randomUUID();
			//Randomly dondurup asagiya veriyor.
			return insertPerson(id, person);
		}
		
		List<Person> selectAllPeople();
		
		Optional<Person> selectPersonById(UUID id);
		
		int deletePersonById(UUID id);
		
		int updatePersonById(UUID id, Person person);
		
}