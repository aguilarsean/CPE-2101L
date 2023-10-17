package LE_5_1;

import java.util.Scanner;

class CashRegister {
    private int cashOnHand;

    CashRegister() {
        this.cashOnHand = 500;
    }

    CashRegister(int cashIn) {
        this.cashOnHand = cashIn;
    }

    public int getCurrentBalance() {
        return cashOnHand;
    }

    public void acceptAmount(int amountIn) {
        this.cashOnHand += amountIn;
    }
}

class DispenserType{
    private int numberOfItems;
    private int cost;

    DispenserType() {
        this.numberOfItems = 0;
        this.cost = 0;
    }

    DispenserType(int setNoOfItems, int setCost) {
        this.numberOfItems = setNoOfItems;
        this.cost = setCost;
    }

    public int getNoOfItems() {
        return numberOfItems;
    }

    public int getCost() {
        return cost;
    }

    public void makeSale() {
        if (this.numberOfItems > 0) {
            this.numberOfItems--;
        }
    }
}

public class JuiceMachine {
    private static CashRegister cashRegister = new CashRegister();
    private static DispenserType[] dispenserType = new DispenserType[4];
    static Scanner scanner = new Scanner(System.in);
    static String[] items = {"Apple Juice", "Orange Juice", "Mango Lassi", "Fruit Punch"};

    public static void showSelection() {
        System.out.println("Select a product:");
        for (int i = 0; i < dispenserType.length; i++) {
            DispenserType dispenser = dispenserType[i];
            System.out.println((i + 1) + ". " + items[i] + " - Cost: " + dispenser.getCost() + " cents");
        }
        System.out.println("0. Exit");
    }

    public static void sellProduct(int selection, int numOfItems) {
        if (selection >= 1 && selection <= dispenserType.length) {
            DispenserType selectedDispenser = dispenserType[selection - 1];

            if (selectedDispenser.getNoOfItems() > 0) {
                int productCost = numOfItems * (selectedDispenser.getCost());
                int depositedAmount = 0;

                System.out.print("\nPlease deposit " + productCost + " cents to buy " + items[selection - 1] + ": ");

                while (depositedAmount < productCost) {
                    int deposit = scanner.nextInt();
                    scanner.nextLine();

                    depositedAmount += deposit;
                    int remainingBalance = productCost - depositedAmount;

                    if (remainingBalance > 0) {
                        System.out.print("Please deposit " + remainingBalance + " more to buy: ");
                    } else {
                        cashRegister.acceptAmount(depositedAmount);

                        for (int i = 1; i <= numOfItems; i++) {
                            selectedDispenser.makeSale();
                        }

                        System.out.println("\nEnjoy your " + items[selection - 1] + "!");
                        break;
                    }
                }

                if (depositedAmount < productCost) {
                    System.out.println("Transaction canceled! Returning money");
                }
            } else {
                System.out.println("Sorry, this product is sold out.");
            }
        }
    }

    public static void main(String[] args) {
        dispenserType[0] =  new DispenserType(10,50);
        dispenserType[1] =  new DispenserType(15,60);
        dispenserType[2] =  new DispenserType(20,70);
        dispenserType[3] =  new DispenserType(25,80);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWelcome the the Juice Machine!");
            showSelection();
            System.out.print("\nEnter the number of the product you want to buy (1-" + dispenserType.length + "): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.print("How many will you buy? ");
            int numOfItems = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                isRunning = false;
                System.out.println("Thank you for using the Juice Machine. Have a great day!");
            } else {
                sellProduct(choice, numOfItems);
            }
        }
    }
}
