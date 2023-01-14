package pl.javastart.task;

import java.util.Scanner;

public class Main {
    private static Person[] people = new Person[3];
    private static int peopleNumber = 0;

    public static void main(String[] args) {

        System.out.println("Podaj informacje o " + people.length + " osobach.");

        do {
            System.out.println("Osoba numer " + (peopleNumber + 1));
            Person createdPerson = createPerson();
            if (!isDuplicate(createdPerson)) {
                addPersonToTab(createdPerson);
            } else {
                System.out.println("Duplikat");
            }
        } while (peopleNumber < people.length);
        System.out.println("Koniec Programu");

        printArrayInfo();

    }

    private static Person createPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj Imię i Nazwisko.");
        String fullName = scanner.nextLine();
        System.out.println("Podaj wiek.");
        int age = scanner.nextInt();
        return new Person(fullName, age);
    }

    private static boolean isDuplicate(Person createdPerson) {
        for (Person person : people) {
            if (person != null) {
                if (createdPerson.equals(person)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void addPersonToTab(Person createdPerson) {
        people[peopleNumber] = createdPerson;
        peopleNumber++;
    }

    private static void printArrayInfo() {
        for (Person person : people) {
            System.out.println(person);
        }
    }
}