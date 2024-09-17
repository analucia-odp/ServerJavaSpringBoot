package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person); //inserir uma pessoa com determinado ID

    default int insertPerson(Person person) { //inserir a pessoa sem ID
         UUID id = UUID.randomUUID();
         return insertPerson(id, person);
    }

    List<Person> getAllPersons();

    Optional<Person> getPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
