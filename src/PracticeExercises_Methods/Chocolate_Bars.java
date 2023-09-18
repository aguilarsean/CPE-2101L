package PracticeExercises_Methods;

import java.util.Scanner;

public class Chocolate_Bars {
	public static double[] getBMR(double age, double height, double weight) {
		double bmrWoman = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		double bmrMan = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		
		double[] bmr = {bmrWoman, bmrMan};
		return bmr;
	}
	
	public static double[] getCalculation(double[] bmr) {
		double woman = bmr[0] / 230;
		double man = bmr[1] / 230;
		
		double[] calculated = {woman, man};
		return calculated;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double age, height, weight;
		
		System.out.print("Enter weight in pounds: ");
		weight = scanner.nextDouble();

		System.out.print("Enter height in inches: ");
		height = scanner.nextDouble();
		
		System.out.print("Enter age in years: ");
		age = scanner.nextDouble();
		
		double[] calculated = getCalculation(getBMR(age, height, weight));
		
		
		System.out.println("Number of chocolate bars required for woman: " + calculated[0]);
		System.out.println("Number of chocolate bars required for man: " + calculated[1]);
		
		scanner.close();
	}
}
