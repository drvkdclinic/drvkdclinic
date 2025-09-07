package com.drvkdclinic.repositoryitf;

import com.drvkdclinic.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository {
    Optional<Person> findPersonById(int id);
    List<Person> getAllPersons();
    void registerPerson(Person person);
}
