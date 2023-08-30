package Aug_30;

import java.util.Scanner;

public class Change_Denomination {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter amount (from 1 - 99 cents): ");
		int amt = scanner.nextInt();
		
		int quarter = amt / 25;
		amt%=25;
		int dime = amt / 10;
		amt%=10;
		int nickel = amt / 5;
		amt%=5;
		int penny = amt / 1;
		amt%=1;
		
		System.out.println("Your change is");
		System.out.println(quarter + " quarter");
		System.out.println(dime + " dime");
		System.out.println(nickel + " nickel");
		System.out.println(penny + " penny");
		
		scanner.close();
	}
}

