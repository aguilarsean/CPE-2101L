package LE_3_1;

import java.util.Scanner;

public class Day_of_the_Week {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		int q, m, j, k, h, year;
		
		System.out.print("Enter year: (e.g., 2012): ");
		year = scanner.nextInt();
		
		System.out.print("Enter month: ");
		m = scanner.nextInt();
		
		System.out.print("Enter the day of the month: 1-31: ");
		q = scanner.nextInt();
		
		if (m == 1 || m == 2) {
			year -= 1;
			m = (m==1) ? 13 : 14;
		}
		
		j = year/100;
		k = year % 100;
		h = (q + 26*(m+1)/10 + k + k/4 + j/4 + 5*j) % 7;
		
		System.out.println("Day of the Week is " + days[h]);
		
		scanner.close();
		
	}
}
