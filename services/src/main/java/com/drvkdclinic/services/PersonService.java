package com.drvkdclinic.services;

import com.drvkdclinic.entity.Person;
import com.drvkdclinic.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

public class PersonService {

    public PersonService(PersonRepository personRepository) {
        this.mPersonRepository = personRepository;
    }

    public Optional<Person> findPersonById(int id) {
        return mPersonRepository.findPersonById(id);
    }

    public List<Person> findAllPersons() {
        return mPersonRepository.getAllPersons();
    }

    public void registerPerson(Person person) {
        mPersonRepository.registerPerson(person);
    }

    private PersonRepository mPersonRepository;
}
