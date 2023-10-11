package LE_5_1;

import java.util.Scanner;

class CashRegister {
    private int cashOnHand;

    public CashRegister() {
        cashOnHand = 500;
    }

    public CashRegister(int cashIn) {
        cashOnHand = cashIn;
    }

    public int getCurrentBalance() {
        return cashOnHand;
    }

    public void acceptAmount(int amountIn) {
        cashOnHand += amountIn;
    }
}

class Dispenser {
    private int numberOfItems;
    private int cost;

    public Dispenser() {
        numberOfItems = 50;
        cost = 50;
    }

    public Dispenser(int setNoOfItems, int setCost) {
        numberOfItems = setNoOfItems;
        cost = setCost;
    }

    public int getNoOfItems() {
        return numberOfItems;
    }

    public int getCost() {
        return cost;
    }

    public void makeSale() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
    }
}

public class JuiceMachine {
    private CashRegister cashRegister;
    private Dispenser[] dispensers;
    String[] items = {"Apple Juice", "Orange Juice", "Mango Lassi", "Fruit Punch"};

    public JuiceMachine() {
        cashRegister = new CashRegister(1000);
        dispensers = new Dispenser[4];

        dispensers[0] = new Dispenser(10, 50);
        dispensers[1] = new Dispenser(5, 75);
        dispensers[2] = new Dispenser(7, 60);
        dispensers[3] = new Dispenser(15, 40);
    }

    public void showSelection() {
        System.out.println("Available Products:");
        for (int i = 0; i < dispensers.length; i++) {
            System.out.println(i + 1 + ". " + items[i] + " - Price: " + dispensers[i].getCost() + " cents, Items available: " + dispensers[i].getNoOfItems());
        }
    }

    public void sellProduct(int selection) {
        if (selection >= 1 && selection <= dispensers.length) {
            Dispenser selectedDispenser = dispensers[selection - 1];

            if (selectedDispenser.getNoOfItems() > 0) {
                int productCost = selectedDispenser.getCost();

                if (cashRegister.getCurrentBalance() >= productCost) {
                    selectedDispenser.makeSale();
                    cashRegister.acceptAmount(productCost);
                    System.out.println("You have purchased a product!");
                } else {
                    System.out.println("Insufficient funds! Please insert more money.");
                }
            } else {
                System.out.println("Sorry, this product is out of stock.");
            }
        } else {
            System.out.println("Invalid Selection! Please try again.");
        }
    }

    public void main() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWelcome to the Juice Machine!\n");
            showSelection();
            System.out.println("Enter the number of the product you want to buy (1-" + dispensers.length + "), or enter 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                isRunning = false;
                System.out.println("Thank you for using the Juice Machine. Have a great day!");
            } else {
                sellProduct(choice);
            }
        }
    }

    public static void main(String[] args) {
        JuiceMachine juiceMachine = new JuiceMachine();
        juiceMachine.main();
    }
}
