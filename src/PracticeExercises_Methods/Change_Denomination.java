package PracticeExercises_Methods;
// package Aug_30;

import java.util.Scanner;

public class Change_Denomination {
	public static int[] changeAmount(int amount) {
		int quarter = amount / 25;
		amount%=25;
		int dime = amount / 10;
		amount%=10;
		int nickel = amount / 5;
		amount%=5;
		int penny = amount;
		amount%=1;
		
		int[] change = {quarter, dime, nickel, penny};
		return change;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter amount (from 1 - 99 cents): ");
		int amt = scanner.nextInt();
		
		int[] change = changeAmount(amt);
		
		System.out.println("Your change is");
		System.out.println(change[0] + " quarter");
		System.out.println(change[1] + " dime");
		System.out.println(change[2] + " nickel");
		System.out.println(change[3] + " penny");
		
		scanner.close();
	}
}

