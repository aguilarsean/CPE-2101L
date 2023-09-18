package PracticeExercises_Methods;

import java.util.Scanner;

public class Day_of_the_Week {
	public static String calculateDayOfWeek(int year, int m, int q) {
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        
        if (m == 1 || m == 2) {
    		year -= 1;
    		m = (m==1) ? 13 : 14;
    	}
    
    	int j = year/100;
    	int k = year % 100;
    	int h = (q + 26*(m+1)/10 + k + k/4 + j/4 + 5*j) % 7;
    	
    	return days[h];
    }
    
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int q, m, h, year;
    
    	System.out.print("Enter year: (e.g., 2012): ");
    	year = scanner.nextInt();
    
    	System.out.print("Enter month: ");
    	m = scanner.nextInt();
    
    	System.out.print("Enter the day of the month: 1-31: ");
    	q = scanner.nextInt();
    	
    	String DayOfTheWeek = calculateDayOfWeek(year, m, q);
    
    	System.out.println("Day of the Week is " + DayOfTheWeek);
    
    	scanner.close();
	}
}
