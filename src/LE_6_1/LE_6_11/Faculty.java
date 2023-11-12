package LE_6_1.LE_6_11;

public class Faculty extends Employee {
    private String officeHours;
    private String rank;

    Faculty(String name, String address, String phoneNumber, String email, String office, double salary, String officeHours, String rank) {
        super(name, address, phoneNumber, email, office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + "\nOffice Hours: " + officeHours + "\nRank: " + rank;
    }
}
