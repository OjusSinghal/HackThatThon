package com.ojus.sampleFullStack.exception;

public class PersonNotFoundException extends RuntimeException
{
    public PersonNotFoundException(String message)
    {
        super(message);
    }
}
