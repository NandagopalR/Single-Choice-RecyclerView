package com.nanda.singlecheck.entity;

public class PersonItem {
    private String personName;

    public PersonItem(String name) {
        personName = name;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
