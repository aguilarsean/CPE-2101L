package PracticeExercises_Methods;

import java.util.Scanner;

public class Distance_between_Two_Points {
	public static double[] getPoint(Scanner scanner) {
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		
		return new double[]{x, y};
	}
	
	public static double calculateDistance(double[] pointOne, double[] pointTwo) {
		double x = (pointTwo[0] - pointOne[0]) * (pointTwo[0] - pointOne[0]);
		double y = (pointTwo[1] - pointOne[1]) * (pointTwo[1] - pointOne[1]);
		
		double distance = Math.pow(x+y, 0.5);
		return distance;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter x1 and y1: ");
		double[] pointOne = getPoint(scanner);
		
		System.out.print("Enter x2 and y2: ");
		double[] pointTwo = getPoint(scanner);
		
		double distance = calculateDistance(pointOne, pointTwo);
		
		System.out.println("The distance between the two points is " + distance);
		
		scanner.close();
	}
}
