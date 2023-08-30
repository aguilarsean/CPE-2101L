package Aug_30;

import java.util.Scanner;

public class Distance_between_Two_Points {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter x1 and y1: ");
		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();
		
		System.out.print("Enter x2 and y2: ");
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();
		
		double x = (x2-x1) * (x2-x1);
		double y = (y2-y1) * (y2-y1);
		
		double z = x + y;
		double result = Math.pow(z, 0.5);
		
		System.out.println("The distance between the two points is " + result);
		
		scanner.close();
	}
}
