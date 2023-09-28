package LE_4_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonTypeGUI {
    JFrame frame;
    JButton submitButton;
    JPanel groupField, namePanel1, namePanel2;
    JLabel label1, label2;
    JTextField inputField1, inputField2;
    JTextArea textArea;
    PersonType personType = new PersonType();

    public PersonTypeGUI() {
        frame = new JFrame("Person Type");

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        namePanel1 = new JPanel(new GridLayout());
        namePanel2 = new JPanel(new GridLayout());
        groupField = new JPanel(new GridLayout(3,1, 10,10));

        label1 = new JLabel("First name:");
        inputField1 = new JTextField(2);

        label2 = new JLabel("Last name:");
        inputField2 = new JTextField(2);

        submitButton = new JButton("Enter");

        textArea = new JTextArea(4, 5);
        textArea.setEditable(false);

        namePanel1.add(label1);
        namePanel1.add(inputField1);
        namePanel2.add(label2);
        namePanel2.add(inputField2);

        groupField.add(namePanel1);
        groupField.add(namePanel2);
        groupField.add(submitButton);

        frame.add(groupField, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstName = inputField1.getText();
                String lastName = inputField2.getText();
                StringBuilder completeName = new StringBuilder();

                personType.setName(firstName, lastName);
                completeName.append(personType.getFirstName()).append(" ").append(personType.getLastName());

                textArea.setText(completeName.toString());
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PersonTypeGUI();
            }
        });
    }
}
