package com.Himanshu.TTN.SpringRestApiExample.versoning;

public class Name {
    private String firstName;
    private String secondName;

    public Name(String firstName, String secondName) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSeconfName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", seconfName='" + secondName + '\'' +
                '}';
    }
}
