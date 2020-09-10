package com.dynamoDbexample.repository;

import com.dynamoDbexample.model.Person;

public interface DynamoDbNewInterface {

    public Person save(Person person);

    public Person getPerson(String id);

    public Person updatePerson(Person person,String id);

    public String deletePerson(String id);
}
