import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hello World? (1 or 0): ");
        int in = scanner.nextInt();
        scanner.nextLine();

        if (in == 1) {
            System.out.println("Hello World!");
        }
        System.out.print("Adios");

        scanner.close();
    }
}
