package DesignPattern1;

import java.util.ArrayList;
import java.util.List;

public class Individual extends Person {
    protected List<Person> children = new ArrayList<>();

    public Individual(String name, String dateOfBirth, String gender, boolean married) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.married = married;
    }

    @Override
    public List<Person> getChildren() {
        return this.children;
    }
    
    @Override
    public void add(Person person) {
        children.add(person);
    } 

    @Override
    public void remove(Person person) {
        children.remove(person);
    }

    @Override
    public String printInfo() {
        String res = "=========================\n";
        res += "Name: " + this.getName() + "\n";
        res += ("D.O.B: " + this.getDateOfBirth() + "\n");
        res += ("Gender: " + this.getGender() + "\n");
        res += "Marital Status: ";
        if (married) {
            res += ("Married" + "\n");
            res += ("Spouse: " + this.partner.getName() + "\n");
            if (!this.children.isEmpty()) {
                res += (this.getName() + "'s " + "Childen: " + "\n");
                for (Person child : children) {
                    res += (child.printInfo() + "\n");
                }
            }
        } else {
            res += ("Single" + "\n");
        }
        return res;
    }
}
