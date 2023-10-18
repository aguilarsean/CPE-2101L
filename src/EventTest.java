package AGU;

import java.util.ArrayList;

class Event {
	public static final int PRICE_PER_GUEST = 35;
	public static final int CUTOFF_GUESTS = 50;
	private String eventNumber;
	private int numberOfGuests;
	private int price;
		
	Event() {
		this("A000", 0);
	}
	
	Event(String eventNumber, int numberOfGuests) {
		setEventNumber(eventNumber);
		setGuests(numberOfGuests);
	}
	
	public void setEventNumber(String eventNumber) {
		this.eventNumber = eventNumber;
	}
	
	public void setGuests(int numOfGuests) {
		if (numOfGuests > CUTOFF_GUESTS) {
			return;
		}
		
		this.numberOfGuests = numOfGuests;
		this.price = this.numberOfGuests * PRICE_PER_GUEST;
	}
	
	public String getEventNumber() {
		return eventNumber;
	}
	
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	
	public int getPrice() {
		return price;
	}
}

public class EventTest {
	public static void main(String[] args) {
		ArrayList<Event> events = new ArrayList<Event>(); 
		
		events.add(0, new Event("A001", 50));
		events.add(1, new Event("A002", 30));
		events.add(2, new Event("A003", 10));
		events.add(3, new Event());
		
		for (int i = 0; i < events.size(); i++) {
			System.out.println("Event Number: " + events.get(i).getEventNumber() + "\tNumber of Guests: " + events.get(i).getNumberOfGuests() + "\tPrice: " + events.get(i).getPrice());
		}
	}
}