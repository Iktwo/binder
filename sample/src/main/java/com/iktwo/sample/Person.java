package com.iktwo.sample;

public class Person {
    public String firstName;
    public String lastName;
    public boolean isVI;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, boolean isVI) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVI = isVI;
    }
}
