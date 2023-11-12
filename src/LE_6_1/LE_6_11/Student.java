package LE_6_1.LE_6_11;

public class Student extends Person {
    private int status;
    public final static int FRESHMAN = 1;
    public final static int SOPHOMORE = 2;
    public final static int JUNIOR = 3;
    public final static int SENIOR = 4;

    Student(String name, String address, String phoneNumber, String email, int status) {
        super(name, address, phoneNumber, email);
        this.status = status;
    }

    public String getStatus() {
        switch (status) {
            case 1:
                return "Freshman";
            case 2:
                return "Sophomore";
            case 3:
                return "Junior";
            case 4:
                return "Senior";
            default:
                return "Unknown";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nStatus: " + getStatus();
    }
}
