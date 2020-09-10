package com.dynamoDbexample.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;

@DynamoDBDocument //this annotation is used show the internal class as to be serializable for dynamodb
public class Address implements Serializable {
    @DynamoDBAttribute(attributeName = "houseNumber")
    private String houseNumber;
    @DynamoDBAttribute(attributeName = "streetNo.")
    private String street;
    @DynamoDBAttribute(attributeName = "pinCode")
    private String pinCode;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
