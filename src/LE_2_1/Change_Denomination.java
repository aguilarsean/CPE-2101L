package LE_2_1;
// package Aug_30;

import java.util.Scanner;

/**
 ======================================================================
 CLASS NAME : LE_2_1.Change_Denomination
 DESCRIPTION : Determines the change to be dispenses from a vending machine. Denomination is in a formed of: quarter, dime, nickel, and penny.
 AUTHOR : Sean Karl Tyrese Aguilar (SKTA)
 COPYRIGHT : Aug 30, 2023
 REVISION HISTORY
 Date:		By:		Description:
 ======================================================================
 */
public class Change_Denomination {
	/**
	 ======================================================================
	 METHOD : main
	 DESCRIPTION : It takes user input as the amount and displays the number of quarters, dimes, nickels, and pennies as the change.
	 PRE-CONDITION : The user must enter an amount between 1 and 99 cents.
	 POST-CONDITION : Program displays the number of quarters, dimes, nickels, and pennies as the change.
	 ======================================================================
	 */
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
		int penny = amt;
		amt%=1;
		
		System.out.println("Your change is");
		System.out.println(quarter + " quarter");
		System.out.println(dime + " dime");
		System.out.println(nickel + " nickel");
		System.out.println(penny + " penny");
		
		scanner.close();
	}
}

