package DesignPattern1;

import java.util.List;

public abstract class Person {
    protected String name;
    protected String dateOfBirth;
    protected String gender;
    protected boolean married = false;
    protected Person partner = null;

    public String getName() {
        return this.name;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public boolean getMarried() {
        return this.married;
    }

    public Person getPartner() {
        return this.partner;
    }

    public void setPartner(Person person) {
        this.partner = person;
    }

    public abstract void add(Person person);
    public abstract void remove(Person person);
    public abstract String printInfo();
    public abstract List<Person> getChildren();
}
