package PME;

import java.util.Scanner;

public class PME_MP1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter value one: ");
		int value1 = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter value two: ");
		int value2 = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println();
		
		if (value1 > value2) {
			System.out.println(value1 + " is GREATER THAN " + value2);
		} else if (value1 == value2) {
			System.out.println(value1 + " is EQUAL TO " + value2);
		} else {
			System.out.println(value1 + " is LESSER THAN " + value2);
		}
		
		scanner.close();
	}
}
