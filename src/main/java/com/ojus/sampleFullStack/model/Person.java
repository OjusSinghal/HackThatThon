package com.ojus.sampleFullStack.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // Because we want the objects of this class to be stored in an "entity" (table) in a database

public class Person implements Serializable
{
    @Id // every database must have an id
    @GeneratedValue(strategy = GenerationType.AUTO) // this field will be auto generated,
                                                    // type -> specifies how this id will be generated, not so important
    @Column(nullable = false, updatable = false) // this column can't be set to null and can't be updated
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public long getId()
    {
        return id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

//@Entity
//class announcements implements seri
//{
//    private id;
//    private date;
//    private timestamp;
//}