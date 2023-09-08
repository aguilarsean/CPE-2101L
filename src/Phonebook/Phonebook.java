package Phonebook;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

class Contact {
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private int no;

	public Contact(String firstName, String middleName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getNo() {
		return no;
	}

	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	public void setMiddleName(String newMiddleName) {
		this.middleName = newMiddleName;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String combine() {
		return "\n" + no + ". " + firstName + " " + middleName + " " + lastName + "\n" + "\tNumber: " + phoneNumber;
	}
}

public class Phonebook {
	private final ArrayList<Contact> contactList = new ArrayList<>();

	private void updateContacts() {
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			contact.setNo(i + 1);
		}
	}


	public void addContact(Contact contact) {
		contactList.add(contact);
		sortContact();
		updateContacts();
	}

	public void browseContact() {
		for (Contact contact : contactList) {
			System.out.println(contact.combine());
		}
	}

	public void editContact(int no, int choice, String newFirstName, String newMiddleName, String newLastName, String newPhoneNumber) {
		for (Contact contact : contactList) {
			if (contact.getNo() == no) {
				if (choice == 1) {
					if (!newFirstName.isEmpty()) {
						contact.setFirstName(newFirstName);
					}
					if (!newMiddleName.isEmpty()) {
						contact.setMiddleName(newMiddleName);
					}
					if (!newLastName.isEmpty()) {
						contact.setLastName(newLastName);
					}
					sortContact();
					updateContacts();
				} else if (choice == 2) {
					if (!newPhoneNumber.isEmpty()) {
						contact.setPhoneNumber(newPhoneNumber);
					}
				} else {
					System.out.println("Invalid choice! No changes made.");
				}
				System.out.println("Contact edited successfully!");
				return;
			}
		}
		System.out.println("Contact not found! No changes made.");
	}

	public void deleteContact(int no) {
		contactList.removeIf(contact -> contact.getNo() == no);
		updateContacts();
	}

	public void sortContact() {
		contactList.sort(Comparator.comparing(Contact::getFirstName));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Phonebook phonebook = new Phonebook();

		while (true) {
			System.out.println("\nPhonebook:");
			System.out.println("1. Browse Contacts");
			System.out.println("2. Add Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Edit Contact");
			System.out.println("5. Exit");
			System.out.print("\nEnter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				phonebook.browseContact();
			} else if (choice == 2) {
				System.out.print("Enter first name: ");
				String firstName = scanner.nextLine();
				System.out.print("Enter middle name: ");
				String middleName = scanner.nextLine();
				System.out.print("Enter last name: ");
				String lastName = scanner.nextLine();
				System.out.print("Enter phone number: ");
				String phoneNumber = scanner.nextLine();

				Contact newContact = new Contact(firstName, middleName, lastName, phoneNumber);
				phonebook.addContact(newContact);

				System.out.println("Contact added successfully!");
			} else if (choice == 3) {
				System.out.print("Which contact to delete? (1, 2, 3,...): ");
				int numberToDelete = scanner.nextInt();
				scanner.nextLine();

				phonebook.deleteContact(numberToDelete);
				System.out.println("Contact deleted successfully!");
			} else if (choice == 4) {
				System.out.print("Which contact to edit? (1, 2, 3,...): ");
				int noChoice = scanner.nextInt();
				scanner.nextLine();

				System.out.println("What do you want to edit?");
				System.out.println("1. Name");
				System.out.println("2. Phone Number");
				System.out.print("\nEnter your choice: ");
				int editChoice = scanner.nextInt();
				scanner.nextLine();

				String newFirstName = "";
				String newMiddleName = "";
				String newLastName = "";
				String newPhoneNumber = "";

				if (editChoice == 1) {
					System.out.print("Enter new first name (or press Enter to keep it unchanged): ");
					newFirstName = scanner.nextLine();

					System.out.print("Enter new middle name (or press Enter to keep it unchanged): ");
					newMiddleName = scanner.nextLine();

					System.out.print("Enter new last name (or press Enter to keep it unchanged): ");
					newLastName = scanner.nextLine();
				} else if (editChoice == 2) {
					System.out.print("Enter new phone number (or press Enter to keep it unchanged): ");
					newPhoneNumber = scanner.nextLine();
				} else {
					System.out.println("Invalid choice! No changes made.");
					return;
				}
				phonebook.editContact(noChoice, editChoice, newFirstName, newMiddleName, newLastName, newPhoneNumber);
			} else if (choice == 5) {
				System.out.println("Exiting phonebook!");
				break;
			} else {
				System.out.println("Invalid choice! Please try again.");
			}
		}
		scanner.close();
	}
}
