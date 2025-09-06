package com.drvkdclinic.repository;

import com.drvkdclinic.daoitf.IPersonDAO;
import com.drvkdclinic.entity.Person;

import java.util.List;
import java.util.Optional;

public class PersonRepository {

    public PersonRepository(IPersonDAO personDAO) {
        this.mPersonDAO = personDAO;
    }

    public Optional<Person> findPersonById(int id) {
        return mPersonDAO.findPersonById(id);
    }

    public List<Person> getAllPersons() {
        return mPersonDAO.getAllPersons();
    }

    public void registerPerson(Person person) {
        mPersonDAO.registerPerson(person);
    }

    private final IPersonDAO mPersonDAO;
}
