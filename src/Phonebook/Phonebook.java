package Phonebook;

import java.util.*;

class Contact {
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private int index;

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

	public int getIndex() {
		return index;
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

	public void setIndex(int index) {
		this.index = index;
	}

	public String getFullName() {
		String fullName = "";
		if (firstName != null && !firstName.isEmpty()) {
			fullName += firstName;
		}
		if (middleName != null && !middleName.isEmpty()) {
			if (!fullName.isEmpty()) {
				fullName += " ";
			}
			fullName += middleName;
		}
		if (lastName != null && !lastName.isEmpty()) {
			if (!fullName.isEmpty()) {
				fullName += " ";
			}
			fullName += lastName;
		}
		return fullName;
	}
}

class Phonebook {
	private static final ArrayList<Contact> contactList = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

	public List<Contact> getContactList() {
		return Collections.unmodifiableList(contactList);
	}

	public void addContact(Contact contact) {
		contactList.add(contact);
		sortContact();
	}

	public void browseContact() {
		if (contactList.isEmpty()) {
			System.out.println("\nNo contacts to display.");
			return;
		}

		System.out.println("\n+------+------------------------------------+--------------------------+");
		System.out.println("|  No  |                Name                |       Phone Number       |");
		System.out.println("+------+------------------------------------+--------------------------+");
		for (Contact contact : contactList) {
			System.out.printf("|  %2d  | %-34s | %-24s |%n",
					contact.getIndex(),
					contact.getFullName(),
					contact.getPhoneNumber());
		}
		System.out.println("+------+------------------------------------+--------------------------+");
	}

	public boolean editContact(int index, int choice, String newFirstName, String newMiddleName, String newLastName, String newPhoneNumber) {
		for (Contact contact : contactList) {
			if (contact.getIndex() == index) {
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
				} else if (choice == 2) {
					if (!newPhoneNumber.isEmpty()) {
						contact.setPhoneNumber(newPhoneNumber);
					}
				} else {
					System.out.println("\nInvalid choice! No changes made.");
					return false;
				}
				return true;
			}
		}
		return false;
	}

	public boolean deleteContact(int no) {
		int initialSize = contactList.size();
		contactList.removeIf(contact -> contact.getIndex() == no);
		sortContact();
		return contactList.size() < initialSize;
	}

	public void sortContact() {
		contactList.sort(Comparator.comparing(Contact::getFirstName));
		updateContactNumbers();
	}

	private void updateContactNumbers() {
		int index = 1;
		for (Contact contact : contactList) {
			contact.setIndex(index++);
		}
	}

	public static void main(String[] args) {
		Phonebook phonebook = new Phonebook();

		while (true) {
			System.out.println("\nPhonebook:");
			System.out.println("[A]dd");
			System.out.println("[B]rowse");
			System.out.println("[C]hange/Edit");
			System.out.println("[D]elete");
			System.out.println("[E]xit");
			System.out.print("\nEnter your choice: ");
			String choice = scanner.nextLine().toUpperCase();

			switch (choice) {
				case "A":
					System.out.print("Enter first name: ");
					String firstName = scanner.nextLine();
					System.out.print("Enter middle name: ");
					String middleName = scanner.nextLine();
					System.out.print("Enter last name: ");
					String lastName = scanner.nextLine();
					System.out.print("Enter phone number: ");
					String phoneNumber = scanner.nextLine();

					if (!firstName.isEmpty() || !middleName.isEmpty() || !lastName.isEmpty() || !phoneNumber.isEmpty()) {
						Contact newContact = new Contact(firstName, middleName, lastName, phoneNumber);
						phonebook.addContact(newContact);

						System.out.println("\nContact added successfully!");
					} else {
						System.out.println("\nNo changes made.");
						break;
					}
					break;
				case "B":
					phonebook.browseContact();
					break;
				case "C":
					if (contactList.isEmpty()) {
						System.out.println("\nPhonebook is empty! No changes made.");
						break;
					}

					System.out.print("\nWhich contact to edit? (1, 2, 3,...): ");
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
						System.out.println("\nInvalid choice! No changes made.");
						return;
					}
					phonebook.editContact(noChoice, editChoice, newFirstName, newMiddleName, newLastName, newPhoneNumber);
					break;
				case "D":
					if (contactList.isEmpty()) {
						System.out.println("\nPhonebook is empty! No changes made.");
						break;
					}

					System.out.print("Which contact to delete? (1, 2, 3,...): ");
					int numberToDelete = scanner.nextInt();
					scanner.nextLine();

					phonebook.deleteContact(numberToDelete);
					System.out.println("Contact deleted successfully!");
					break;
				case "E":
					System.out.println("Exiting phonebook!");
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
					break;
			}
		}
	}
}
