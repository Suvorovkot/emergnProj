package com.emergn.course.models;

public class Album {
    private String firstName;
    private String lastName;
    private String stageName;

    public Album(String firstName, String lastName, String stageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStageName() {
        return stageName;
    }
}
