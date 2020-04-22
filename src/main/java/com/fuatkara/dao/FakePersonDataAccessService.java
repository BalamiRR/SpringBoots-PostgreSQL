package com.fuatkara.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.fuatkara.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
	//Person class'imizi cagirdik, personlarimizi listelemek icin
	//adinada DB dedik
	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		//Person class'indan geliyor getName();
		//id.getId() yok cunku biz id'yi random yaptik
		//id yukaridaki paramatreden geliyor.
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(person-> person.getId().equals(id))
				.findFirst();
	}

	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMaybe = selectPersonById(id);
		if(personMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(personMaybe.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person update) {
		return selectPersonById(id)
				.map(person ->{
					int indexOfPersonToDelete = DB.indexOf(person);
					if( indexOfPersonToDelete >= 0) {
						DB.set(indexOfPersonToDelete,new Person(id, update.getName()));
						return 1;
					}return 0;
				}).orElse(0);
	}
}