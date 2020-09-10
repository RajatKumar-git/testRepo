package com.dynamoDbexample.controller;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.dynamoDbexample.model.Person;
import com.dynamoDbexample.repository.DynamoDbOps;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DynamoDBController {

    @Inject
    DynamoDB dynamoDB;

    @Inject
    DynamoDbOps dynamoDbOps;

    @PostMapping(value = "/addPerson")
    public Person addPerson(@RequestBody Person person) {
        dynamoDbOps.save(person);
        return person;
    }

    @GetMapping(value = "/getPerson/{id}")
    public Person getPerson(@PathVariable String id){
        Person person=dynamoDbOps.getPerson(id);
        return person;
    }

    @DeleteMapping(value="/deletePerson")
    public String deletePerson(@RequestParam String id){
        String response=dynamoDbOps.deletePerson(id);
        return response;
    }
}
