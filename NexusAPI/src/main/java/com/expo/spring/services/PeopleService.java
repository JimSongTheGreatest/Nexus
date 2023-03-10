package com.expo.spring.services;

import com.expo.spring.models.Person;
import com.expo.spring.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public Person save(Person person) {
        peopleRepository.save(person);
        return person;
    }

    @Transactional
    public Person update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
        return updatedPerson;
    }

    @Transactional
    public boolean delete(int id) {
        peopleRepository.deleteById(id);
        return false;
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return peopleRepository.findByEmail(fullName);
    }

}
