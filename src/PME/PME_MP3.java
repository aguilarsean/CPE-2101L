package PME;

import java.util.Scanner;

public class PME_MP3 {
	public static int sum(int val1, int val2) {
		return val1 + val2;
	}
	
	public static int difference(int val1, int val2) {
		return val1 - val2;
	}
	
	public static int product(int val1, int val2) {
		return val1 * val2;
	}
	
	public static double quotient(int val1, int val2) {
		return val1 / val2;
	}
	
	public static void main(String[] args) {
		String tryAgain;
		int val1, val2;
		Scanner scanner = new Scanner(System.in);
		

		
		while (true) {
			System.out.print("Enter val1: ");
			val1 = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter val2: ");
			val2  = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("MENU");
			System.out.println("[A] Add");
			System.out.println("[B] Subtract");
			System.out.println("[C] Multiply");
			System.out.println("[D] Divide");
			System.out.println("[E] Exit");
			
			System.out.print("Choice? ");
			String choice = scanner.nextLine();
			
			System.out.println();
			
			switch (choice) {
			case "A":
				int sum = sum(val1, val2);
				System.out.println(val1 + " + " + val2 + " = " + sum);
				break;
			case "B":
				int difference = difference(val1, val2);
				System.out.println(val1 + " - " + val2 + " = " + difference);
				break;
			case "C":
				int product = product(val1, val2);
				System.out.println(val1 + " * " + val2 + " = " + product);
				break;
			case "D":
				double quotient = quotient(val1, val2);
				System.out.println(val1 + " / " + val2 + " = " + quotient);
				break;
			case "E":
				System.out.println("Exiting!");
				break;
			default:
				System.out.println("Invalid choice! No changes made.");
				break;
			}
			
			System.out.println();
			System.out.print("AGAIN [Y/N]? ");
			tryAgain = scanner.nextLine();
			
			switch (tryAgain) {
			case "Y":
				continue;
			default:
				System.exit(0);
			}
		}
	}
}
