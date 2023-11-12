package LE_6_1.LE_6_11;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    Person() {
        this("Unknown", "Unknown", "Unknown", "Unknown");
    }

    Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Person.this.phoneNumber;
    }

    public void setEmail(String email) {
        this.email = Person.this.email;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}
