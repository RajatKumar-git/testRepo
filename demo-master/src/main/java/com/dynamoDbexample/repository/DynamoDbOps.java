package com.dynamoDbexample.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.dynamoDbexample.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DynamoDbOps implements DynamoDbNewInterface{
    @Inject
    DynamoDBMapper dynamoDBMapper;

    @Override
    public Person save(Person person) {
        dynamoDBMapper.save(person);
        return person;
    }

    @Override
    public Person getPerson(String id) {
        return dynamoDBMapper.load(Person.class,id);
    }

    @Override
    public Person updatePerson(Person person, String id) {
        return dynamoDBMapper.load(person);
    }

    @Override
    public String deletePerson(String id) {
        Person person=dynamoDBMapper.load(Person.class,id);
        dynamoDBMapper.delete(person);
        return "person deleted successfully";
    }

    public DynamoDBMapper getDynamoDBMapper() {
        return dynamoDBMapper;
    }
}
