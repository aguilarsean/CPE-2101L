package Aug_30;

import java.util.Scanner;

public class Chocolate_Bars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int age, height, weight, woman, man;
		
		double bmrWoman, bmrMan;
		
		System.out.print("Enter weight in pounds: ");
		weight = scanner.nextInt();
		
		System.out.print("Enter height in inches: ");
		height = scanner.nextInt();
		
		System.out.print("Enter age in years: ");
		age = scanner.nextInt();
		
		bmrWoman = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		bmrMan = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		
		woman = (int) Math.ceil(bmrWoman / 230);
		man = (int) Math.ceil(bmrMan / 230);
		
		System.out.println("Number of chocolate bars required for woman: " + woman);
		System.out.println("Number of chocolate bars required for man: " + man);
		
		scanner.close();
	}
}
