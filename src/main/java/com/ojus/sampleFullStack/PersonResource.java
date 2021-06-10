package com.ojus.sampleFullStack;


import com.ojus.sampleFullStack.model.Person;
import com.ojus.sampleFullStack.repo.PersonRepo;
import com.ojus.sampleFullStack.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PersonResource
{
    private final PersonService personService;

    public PersonResource(PersonService personService)
    {
        this.personService = personService;
    }

    @RequestMapping()
    public ModelAndView home()
    {
        System.out.println("before home page through model and view");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");

        System.out.println("after home page through model and view");
        return mv;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson()
    {
        return new ResponseEntity<>(personService.findAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id)
    {
        return new ResponseEntity<>(personService.findPerson(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person)
    {
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person)
    {
        Person updatedPerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable Long id)
    {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> clearDatabase()
    {
        personService.deleteAllPersons();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}