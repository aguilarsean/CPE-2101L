package ME;

import java.util.ArrayList;
import java.util.Scanner;

class Rental {
	public static final int MINS_IN_HOURS = 60;
	public static final int RENTAL_RATE_HR = 40;
	
	private String contactNumber;
	private double hoursOfRental;
	private double minsOverHour;
	private double price;
	
	public Rental() {
		this("A000", 0);
	}
	
	public Rental(String contactNumber, int numberOfMinutes) {
		setContactNumber(contactNumber);
		setHoursAndMinutes(numberOfMinutes);
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public void setHoursAndMinutes(double minutes) {
		this.minsOverHour = minutes / MINS_IN_HOURS;
		this.hoursOfRental = this.minsOverHour;
		this.price = this.hoursOfRental * RENTAL_RATE_HR;
	}
	
	public String getContactNumber() {
		return this.contactNumber;
	}
	
	public double getHoursOfRental() {
		return this.hoursOfRental;
	}
	
	public double getMinsOverHour() {
		return this.minsOverHour;
	}
	
	public double getPrice() {
		return this.price;
	}
}

public class RentalTest {
	public static void main(String[] args) {	
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		Scanner scanner = new Scanner(System.in);
		
		rentals.add(0, new Rental("CANOE", 300));
		rentals.add(1, new Rental("KAYAK", 100));
		rentals.add(2, new Rental("CHAIRS", 30));
		rentals.add(3, new Rental("UMBRELLAS", 45));
		rentals.add(4, new Rental());
		
		 for (int i = 0; i < rentals.size(); i++) {
			 System.out.println();
			 System.out.println(i+1 + ". Contact Number: " + rentals.get(i).getContactNumber() + 
					 " \tHours of Rental: " + rentals.get(i).getHoursOfRental() + 
					 " \tMinutes: "+ rentals.get(i).getMinsOverHour() +
					 " \tPrice: " + rentals.get(i).getPrice());
		 }
		
		 scanner.close();
	}
}
