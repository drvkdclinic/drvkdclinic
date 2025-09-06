package com.drvkdclinic.daoitf;

import com.drvkdclinic.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO {
    Optional<Person> findPersonById(int id);
    List<Person> getAllPersons();
    void registerPerson(Person person);
}
