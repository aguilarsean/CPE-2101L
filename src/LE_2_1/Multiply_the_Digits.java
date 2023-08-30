package LE_2_1;
// package Aug_30;

import java.util.Scanner;

/**
 ======================================================================
 CLASS NAME : LE_2_1.Multiply_the_Digits
 DESCRIPTION : Reads an integer between 0 and 1000. Display and multiplies all the digits in the integer.
 AUTHOR : Sean Karl Tyrese Aguilar (SKTA)
 COPYRIGHT : Aug 30, 2023
 REVISION HISTORY
 Date:		By:		Description:
 ======================================================================
 */
public class Multiply_the_Digits {
	/**
	 ======================================================================
	 METHOD : main
	 DESCRIPTION : It takes user input as the number and displays the product of all digits in the number,
	 PRE-CONDITION : The user must enter an integer between 0 and 1000.
	 POST-CONDITION : Display and multiplies all the digits in the integer.
	 ======================================================================
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number between 0 and 1000: ");
		int num = scanner.nextInt();
		
		int numOne = num / 100;
		System.out.println(numOne);
		
		int numTwo= num / 10 % 10;
		System.out.println(numTwo);
		
		int numThree= num % 10;
		System.out.println(numThree);
		
		int result = numOne * numTwo * numThree;
		System.out.print("The product of all digits in " + num + " is " + result);
		
		scanner.close();
	}
}
