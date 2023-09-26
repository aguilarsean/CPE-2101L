package LE_4_1;

import java.util.Scanner;

public class PersonType {
    private String firstName;
    private String lastName;

    public PersonType() {
        this.firstName = "";
        this.lastName = "";
    }

    public PersonType(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public void print() {
        System.out.println("\nFirst Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }

    public void setName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        PersonType person = new PersonType();

        person.setName(firstName, lastName);
        person.print();

        scanner.close();
    }
}
