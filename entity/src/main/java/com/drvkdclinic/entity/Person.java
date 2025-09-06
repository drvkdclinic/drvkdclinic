package com.drvkdclinic.entity;

public class Person {
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public void setMiddleName(String middleName) {
        this.mMiddleName = middleName;
    }

    public String getSurName() {
        return mSurName;
    }

    public void setSurName(String surName) {
        this.mSurName = surName;
    }

    private String mFirstName;
    private String mMiddleName;
    private String mSurName;
}
