package LE_2_1;
// package Aug_30;

import java.util.Scanner;

/**
 ======================================================================
 CLASS NAME : LE_2_1.Chocolate_Bars
 DESCRIPTION : Calculates the number of chocolate bars required for a woman and a man based on their weight, height, and age.
 AUTHOR : Sean Karl Tyrese Aguilar (SKTA)
 COPYRIGHT : Aug 30, 2023
 REVISION HISTORY
 Date:		By:		Description:
 ======================================================================
 */
public class Chocolate_Bars {
	/**
	 ======================================================================
	 METHOD : main
	 DESCRIPTION : Prompts the user to enter weight, height, and age, and calculates the number of chocolate bars required for a woman and a man based on their BMR (Basal Metabolic Rate).
	 PRE-CONDITION : The user must enter valid weight, height, and age values.
	 POST-CONDITION : The program displays the number of chocolate bars required for a woman and a man.
	 ======================================================================
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double age, height, weight;
		int woman, man;
		
		double bmrWoman, bmrMan;
		
		System.out.print("Enter weight in pounds: ");
		weight = scanner.nextDouble();

		System.out.print("Enter height in inches: ");
		height = scanner.nextDouble();
		
		System.out.print("Enter age in years: ");
		age = scanner.nextDouble();
		
		bmrWoman = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		bmrMan = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		
		woman = (int) Math.ceil(bmrWoman / 230);
		man = (int) Math.ceil(bmrMan / 230);
		
		System.out.println("Number of chocolate bars required for woman: " + woman);
		System.out.println("Number of chocolate bars required for man: " + man);
		
		scanner.close();
	}
}
