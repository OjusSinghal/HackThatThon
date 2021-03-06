package com.ojus.sampleFullStack.repo;

import com.ojus.sampleFullStack.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long>
{
    
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
    
    Person findByDate(LocalDate date);
//    boolean ExistsByFirstNameAndLastName(String firstName, String lastName);
}
