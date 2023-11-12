package LE_6_1.LE_6_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Cake orderCake(Scanner scanner) {
        System.out.print("Enter the name of the cake: ");
        String cakeName = scanner.nextLine();

        System.out.print("Enter the rate of the cake: ");
        double cakeRate = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the weight of the cake: ");
        double cakeWeight = scanner.nextDouble();
        scanner.nextLine();

        return new OrderCake(cakeName, cakeRate, cakeWeight);
    }

    private static Cake readyMadeCake(Scanner scanner) {
        System.out.print("Enter the cake name: ");
        String cakeName = scanner.nextLine();

        System.out.print("Enter the cake rate: ");
        double cakeRate = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the cake quantity: ");
        int cakeQuantity = scanner.nextInt();
        scanner.nextLine();

        return new ReadymakeCake(cakeName, cakeRate, cakeQuantity);
    }

    private static void displayTotalPrice(ArrayList<Cake> cakes) {
        double totalPrice = cakes.stream().mapToDouble(Cake::calcPrice).sum();
        System.out.println("Total Price of the cakes: " + totalPrice);
    }

    private static void displayReadyMakeCake(ArrayList<Cake> cakes) {
        System.out.println("Ready-Made Cakes Sold:");
        cakes.stream().filter(cake -> cake.getClass() == ReadymakeCake.class).forEach(cake -> System.out.println(cake.toString()));
    }

    private static void displayHighestPriced(ArrayList<Cake> cakes) {
        double highestPrice = cakes.stream().mapToDouble(Cake::calcPrice).max().orElse(0);
        System.out.println("Highest Price Cake Sold: " + highestPrice);
    }

    private static ArrayList<Cake> generateCakesFromFile() {
        ArrayList<Cake> cakesFromFile = new ArrayList<>();

        try {
            File file = new File("data/cakeData.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String cakeType = fileScanner.nextLine();

                if (cakeType.equals("OrderCake")) {
                    String cakeName = fileScanner.nextLine();
                    double cakeRate = Double.parseDouble(fileScanner.nextLine());
                    double cakeWeight = Double.parseDouble(fileScanner.nextLine());

                    cakesFromFile.add(new OrderCake(cakeName, cakeRate, cakeWeight));
                } else if (cakeType.equals("ReadyMakeCake")) {
                    String cakeName = fileScanner.nextLine();
                    double cakeRate = Double.parseDouble(fileScanner.nextLine());
                    int cakeQuantity = Integer.parseInt(fileScanner.nextLine());
                    cakesFromFile.add(new ReadymakeCake(cakeName, cakeRate, cakeQuantity));
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return cakesFromFile;
    }

    private static void printCakesFromFile() {
        ArrayList<Cake> cakes = generateCakesFromFile();
        if (cakes.isEmpty()) {
            System.out.println("No cakes found in the file.");
        } else {
            System.out.println("\nCakes from the file:");
            for (Cake cake : cakes) {
                System.out.println(cake.toString());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Cake> cakes = new ArrayList<>(20);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input method:");
        System.out.println("1. User input");
        System.out.println("2. Automation (from file)");
        System.out.print("Selection: ");
        int inputChoice = scanner.nextInt();
        scanner.nextLine();

        if (inputChoice == 1) {
            while (cakes.size() < 20) {
                System.out.print("\nPress 1 to order cake or press 2 for ready-made cake (Press 0 to finish and display): ");

                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 0) {
                        System.out.println("\nCakes: ");
                        for (Cake cake : cakes) {
                            System.out.println(cake.toString());
                        }
                        break;
                    } else if (choice == 1) {
                        cakes.add(orderCake(scanner));
                    } else if (choice == 2) {
                        cakes.add(readyMadeCake(scanner));
                    } else {
                        System.out.println("Invalid selection! Please try again.");
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Use numbers :>");
                    scanner.nextLine();
                }
            }
        } else if (inputChoice == 2) {
            printCakesFromFile();
        } else {
            System.out.println("Invalid selection!");
        }
    }
}
