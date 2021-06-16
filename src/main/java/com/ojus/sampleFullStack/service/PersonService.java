package com.ojus.sampleFullStack.service;

import com.ojus.sampleFullStack.exception.PersonNotFoundException;
import com.ojus.sampleFullStack.model.Person;
import com.ojus.sampleFullStack.repo.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService
{
    private PersonRepo personRepo;
    
    @Autowired
    public PersonService(PersonRepo personRepo)
    {
        this.personRepo = personRepo;
    }
    
    public Person addPerson(Person person)
    {
//        person.setId(UUID.randomUUID().toString());
        return personRepo.save(person);
    }
    
    public List<Person> findAllPersons()
    {
        return personRepo.findAll();
    }
    
    public Person updatePerson(Person person)
    {
        return personRepo.save(person);
    }
    
    public Person findPerson(Long id)
    {
        return personRepo
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with id: " + id.toString() + " was not found") );
    }
    
    public void deletePerson(Long id)
    {
        personRepo.deleteById(id);
    }
    
    public void deleteAllPersons() { personRepo.deleteAll(); }
    
    public Person findByName(String firstName, String lastName)
    {
        System.out.println(firstName + " " + lastName);
        List<Person> p = personRepo.findByFirstNameAndLastName(firstName, lastName);
        System.out.println(p.get(0));
//        System.out.println(p.toString());
        return p.get(0);
    }
    
    public boolean isPresent(String firstName, String lastName)
    {
        List<Person> personsSatisfied = personRepo.findByFirstNameAndLastName(firstName, lastName);
        return personsSatisfied.size() > 0;
    }
}
