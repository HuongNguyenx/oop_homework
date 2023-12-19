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
            System.out.println(person.getName() + " and " + person.getPartner().getName());
        }
        for (Person child : children) {
            parentWithTwoChildren(child);
        }
    }

    public static void newGeneration(Person person) {
        if (person == null) {
            return;
        }
        List<Person> generation = new ArrayList<>();
        Queue<Person> queue = new LinkedList<>();
        queue.offer(person);

        while (!queue.isEmpty()) {
            int n = queue.size();
            generation.clear();

            for (int i = 0; i < n; i++) {
                Person currentPerson = queue.poll();
                generation.add(currentPerson);

                for (Person child : currentPerson.getChildren()) {
                    queue.offer(child);
                }
            }
        }

        for (Person child : generation) {
            System.out.println(child.getName());
        }
    }

    public static void parentWithNoChildren(Person person) {
        List<Person> children = person.getChildren();
        if (person.getMarried() && children.isEmpty()) {
            System.out.println(person.getName() + " and " + person.getPartner().getName());
        } else if (!children.isEmpty()) {
            for (Person child : children) {
                parentWithNoChildren(child);
            }
        }
    }
}
