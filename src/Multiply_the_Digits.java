package Aug_30;

import java.util.Scanner;

public class Multiply_the_Digits {
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
