package PracticeExercises_Methods;

import java.util.Scanner;

public class Dec_to_Hex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a decimal number: ");
		int decimalNumber = scanner.nextInt();

		String hexString = decimalToHex(decimalNumber).toUpperCase();

		System.out.print("Hexadecimal number: " + hexString);

		scanner.close();
	}

	public static String decimalToHex(int decimalNumber) {
		if (decimalNumber == 0) {
			return "0";
		}

		StringBuilder hexStringBuilder = new StringBuilder();

		while (decimalNumber > 0) {
			int remainder = decimalNumber % 16;
			char hexDigit = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + remainder - 10);
			hexStringBuilder.insert(0, hexDigit);
			decimalNumber /= 16;
		}

		return hexStringBuilder.toString();
	}
}
