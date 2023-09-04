package LE_3_1;

import java.util.Scanner;

public class Dec_to_Hex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a decimal number: ");
		int decimalNumber = scanner.nextInt();
		
		String hexString = Integer.toHexString(decimalNumber).toUpperCase();
		
		System.out.print("Hexadecimal number: " + hexString);
		
		scanner.close();
	}
}
