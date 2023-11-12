package LE_6_1.LE_6_12;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectSquare extends Factorizer {
    PerfectSquare() {
        factors = new ArrayList<>();
    }

    @Override
    public void getFactors(int m) {
        for (int i = 2; i <= m; i++) {
            while (m % i == 0) {
                factors.add(i);
                m /= i;
            }
        }
    }

    public void calculatePerfectSquare() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer m: ");
        int m = scanner.nextInt();
        getFactors(m);

        int n = getSmallestNumber();
        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + (m * n));
    }

    public static void main(String[] args) {
        PerfectSquare calculator = new PerfectSquare();
        calculator.calculatePerfectSquare();
    }
}
