package DesignPattern1;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Individual james = new Individual("James", "22/12/1971", "Male", true);
        Individual hana = new Individual("Hana", "04/11/1976", "Female", true);
        Individual kai = new Individual("Kai", "25/08/1996", "Male", true);
        Individual ryan = new Individual("Ryan", "15/10/1997", "Male", false);
        Individual jennifer = new Individual("Jennifer", "11/02/1996", "Female", true);

        james.setPartner(hana);
        kai.setPartner(jennifer);
        james.add(ryan);
        james.add(kai);

        Individual luan = new Individual("Luan", "22/05/2021", "Male", false);
        Individual tom = new Individual("Tom", "22/11/2023", "Male", false);
        Individual anna = new Individual("Anna", "18/11/20024", "Female", false);
        Individual elsa = new Individual("Elsa", "13/03/2024", "Female", false);
        kai.add(luan);
        kai.add(tom);
        kai.add(anna);
        kai.add(elsa);

        //System.out.println(james.printInfo());
        //parentWithTwoChildren(james);
        newGeneration(james);
        
    }

    public static void parentWithTwoChildren(Person person) {
        List<Person> children = person.getChildren();
        if (children.size() == 2) {
            System.out.println(person.getName() + " and " + person.partner.getName());
        }
        for (Person child : children) {
            parentWithTwoChildren(child);
        }
    }

    public static void newGeneration(Person person) {
        List<Person> children = person.getChildren();
        if (children.isEmpty()) {
            System.out.println(person.getName());
        } else {
            for (Person child : children) {
                newGeneration(child);
            }
        }
    }
}
