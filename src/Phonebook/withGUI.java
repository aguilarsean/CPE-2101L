package Phonebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class withGUI {
    JFrame frame;
    JPanel buttons;
    JButton browseButton, addButton, deleteButton, editButton;
    JTextArea textArea;
    JScrollPane scrollPane;
    Phonebook phonebook;

    public withGUI() {
        frame = new JFrame("Sean's Phonebook");
        buttons = new JPanel(new GridLayout(2, 2, 10, 10));
        browseButton = new JButton("Browse Contacts");
        addButton = new JButton("Add Contact");
        deleteButton = new JButton("Delete Contact");
        editButton = new JButton("Edit Contact");
        textArea = new JTextArea(8, 20);
        scrollPane = new JScrollPane(textArea);
        phonebook = new Phonebook();

        buttons.add(browseButton);
        buttons.add(addButton);
        buttons.add(deleteButton);
        buttons.add(editButton);

        browseButton.setPreferredSize(new Dimension(100,40));
        addButton.setPreferredSize(new Dimension(100,40));
        deleteButton.setPreferredSize(new Dimension(100,40));
        editButton.setPreferredSize(new Dimension(100,40));

        textArea.setEditable(false);

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        frame.add(buttons, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder contactText = new StringBuilder();

                for (Contact contact : phonebook.getContactList()) {
                    contactText.append(contact.combine()).append("\n");
                }

                textArea.setText(contactText.toString());
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstName = JOptionPane.showInputDialog("Enter your first name:");
                String middleName = JOptionPane.showInputDialog("Enter your middle name:");
                String lastName = JOptionPane.showInputDialog("Enter your last name:");
                String phoneNumber = JOptionPane.showInputDialog("Enter your phone number:");

                Contact newContact = new Contact(firstName, middleName, lastName, phoneNumber);
                phonebook.addContact(newContact);

                JOptionPane.showMessageDialog(null, "Contact added successfully!");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String input = JOptionPane.showInputDialog("Which contact to delete? (1, 2, 3,...):");
                int numberToDelete = Integer.parseInt(input);

                if (phonebook.deleteContact(numberToDelete)) {
                    JOptionPane.showMessageDialog(null, "Contact deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found! No changes made.");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String input = JOptionPane.showInputDialog("Which contact to edit? (1, 2, 3,...):");
                int noChoice = Integer.parseInt(input);

                String[] options = {"Name", "Phone Number"};
                int editChoice = JOptionPane.showOptionDialog(null, "What do you want to edit?", "Edit Contact",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                String newFirstName = "";
                String newMiddleName = "";
                String newLastName = "";
                String newPhoneNumber = "";

                if (editChoice == 0) {
                    newFirstName = JOptionPane.showInputDialog("Enter new first name (or press Enter to keep it unchanged):");
                    newMiddleName = JOptionPane.showInputDialog("Enter new middle name (or press Enter to keep it unchanged):");
                    newLastName = JOptionPane.showInputDialog("Enter new last name (or press Enter to keep it unchanged):");
                } else if (editChoice == 1) {
                    newPhoneNumber = JOptionPane.showInputDialog("Enter new phone number (or press Enter to keep it unchanged):");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid choice! No changes made.");
                    return;
                }

                if (phonebook.editContact(noChoice, editChoice + 1, newFirstName, newMiddleName, newLastName, newPhoneNumber)) {
                    JOptionPane.showMessageDialog(null, "Contact edited successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found! No changes made.");
                }

            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new withGUI();
            }
        });
    }
}
