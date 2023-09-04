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

		String dayOfWeek;
		switch (h) {
			case 0:
				dayOfWeek = days[0];
				break;
			case 1:
				dayOfWeek = days[1];
				break;
			case 2:
				dayOfWeek = days[2];
				break;
			case 3:
				dayOfWeek = days[3];
				break;
			case 4:
				dayOfWeek = days[4];
				break;
			case 5:
				dayOfWeek = days[5];
				break;
			case 6:
				dayOfWeek = days[6];
				break;
			default:
				dayOfWeek = "Invalid day";
				break;
		}

		System.out.println("Day of the Week is " + dayOfWeek);
		
		scanner.close();
		
	}
}
