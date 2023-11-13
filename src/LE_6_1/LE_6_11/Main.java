package LE_6_1.LE_6_11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        // Instance of different person
        people.add(new Student("Sean Aguilar", "Basak Mandaue City, Cebu", "09150698943", "seanaguilar698@gmail.com", 2));
        people.add(new Employee("Marlowe Edgar C. Burce, PhD", "University of San Carlos, Talamban Campus", "+63 32 230 0100", "mecburce@usc.edu.ph", "Department of Computer Engineering", 99999));
        people.add(new Faculty("Marlowe Edgar C. Burce, PhD", "University of San Carlos, Talamban Campus", "+63 32 230 0100", "mecburce@usc.edu.ph", "Department of Computer Engineering", 99999, "84", "Full Professor"));
        people.add(new Staff("Stephen Curry", "University of San Carlos, Talamban Campus", "09064572353", "stephencurry@gmail.com", "University of San Carlos, Talamban Campus", 19999, "Janitor"));

        int choice;
        do {
            System.out.println("\nView names:");
            System.out.println("1. Persons");
            System.out.println("2. Students");
            System.out.println("3. Employees");
            System.out.println("4. Faculty");
            System.out.println("5. Staff");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Iterates through the list of people and displays it for all instances of Person
                    System.out.println("\nPERSON");
                    for (Person person : people) {
                        if (person != null) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 2:
                    // Iterates through the list of people and displays it only for instances of Student
                    System.out.println("\nSTUDENT");
                    for (Person person : people) {
                        if (person instanceof Student) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 3:
                    // Iterates through the list of people and displays it only for instances of Employee
                    // excluding Faculty and Staff (to avoid duplication when displaying)
                    System.out.println("\nEMPLOYEE");
                    for (Person person : people) {
                        if (person instanceof Employee && !(person instanceof Faculty || person instanceof Staff)) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 4:
                    // Iterates through the list of people and displays it only for instances of Faculty
                    System.out.println("\nFACULTY");
                    for (Person person : people) {
                        if (person instanceof Faculty) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 5:
                    // Iterates through the list of people and displays it only for instances of Staff
                    System.out.println("\nSTAFF");
                    for (Person person : people) {
                        if (person instanceof Staff) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
}
