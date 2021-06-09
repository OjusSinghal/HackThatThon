package com.ojus.sampleFullStack.repo;

import com.ojus.sampleFullStack.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long>
{

}
