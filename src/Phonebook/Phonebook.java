package Phonebook;

import java.util.Scanner;
import java.util.ArrayList;

class Contact {
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	
	public void contact(String firstName, String middleName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public String combine() {
		return "Name: " + firstName + " " + middleName + " " + lastName + " " + "Number: " + phoneNumber;
	}
	
}

public class Phonebook {
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> ContactList = new ArrayList<>();
	
	public void Contact(Contact contact) {
		System.out.println();
	}
	
	public void menu() {
		System.out.print("1. Browse");
		System.out.print("2. Add Contact");
		System.out.print("3. Delete Contact");
		System.out.print("4. Edit Contact");
	}
	
	
	public static void main(String[] args) { 
		System.out.println("Hello World!");
	}
}
