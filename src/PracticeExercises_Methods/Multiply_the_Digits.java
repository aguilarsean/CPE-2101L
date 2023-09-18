package PracticeExercises_Methods;

import java.util.Scanner;

public class Multiply_the_Digits {
	public static int getNumOne(int num) {
		return num / 100;
	}
	
	public static int getNumTwo(int num) {
		return num / 10 % 10;
	}
	
	public static int getNumThree(int num) {
		return num % 10;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number between 0 and 1000: ");
		int num = scanner.nextInt();
		
		int numOne = getNumOne(num);
		System.out.println(numOne);
		
		int numTwo= getNumTwo(num);
		System.out.println(numTwo);
		
		int numThree= getNumThree(num);
		System.out.println(numThree);
		
		int result = numOne * numTwo * numThree;
		System.out.print("The product of all digits in " + num + " is " + result);
		
		scanner.close();
	}
}
