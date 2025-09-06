package com.drvkdclinic.entity;

public class Person {
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public void setMiddleName(String mMiddleName) {
        this.mMiddleName = mMiddleName;
    }

    public String getSurName() {
        return mSurName;
    }

    public void setSurName(String mSurName) {
        this.mSurName = mSurName;
    }

    private String mFirstName;
    private String mMiddleName;
    private String mSurName;
}
