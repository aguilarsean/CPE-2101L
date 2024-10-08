package PME;

import java.util.Scanner;

public class PME_MP2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Input age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		if (age > 59) {
			System.out.println("SENIOR CITIZEN");
		} else if (age > 19 && age < 60) {
			System.out.println("ADULT");
		} else if (age > 12 && age < 20) {
			System.out.println("TEENAGER");
		} else {
			System.out.println("CHILD");
		}
		
		scanner.close();
	}
}
