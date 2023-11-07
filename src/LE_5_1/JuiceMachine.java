package LE_5_1;

import java.util.Scanner;

class CashRegister {
    private int cashOnHand;

    CashRegister() {
        this.cashOnHand = 500;
    }

    /**
     * Creates a CashRegister with a custom balance
     *
     * @param cashIn - The initial balance of the CashRegister.
     */
    CashRegister(int cashIn) {
        this.cashOnHand = cashIn;
    }

    public int getCurrentBalance() {
        return cashOnHand;
    }

    /**
     * Accepts an amount and adds it to the CashRegister's balance.
     *
     * @param amountIn - The amount to be added to the balance.
     */
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

    /**
     * Creates a DispenserType with a specific number of items and cost.
     *
     * @param setNoOfItems - The initial number of items in the dispenser.
     * @param setCost - The cost of the product in cents.
     */
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
            System.out.println((i + 1) + ". " + items[i] + " - Cost: " + dispenser.getCost() + " cents" + " - No. of Items: " + dispenser.getNoOfItems());
        }
        System.out.println("0. Exit");
    }

    /**
     * Sell a selected product and handle the transaction.
     *
     * @param selection - The user's product selection (1 to 4).
     * @param numOfItems - The quantity of items to be purchased.
     */
    public static void sellProduct(int selection, int numOfItems) {
        if (selection >= 1 && selection <= dispenserType.length) {
            DispenserType selectedDispenser = dispenserType[selection - 1];

            if (selectedDispenser.getNoOfItems() > 0) {
                int productCost = numOfItems * (selectedDispenser.getCost());
                int depositedAmount = 0;
                int tries = 0;

                System.out.print("\nPlease deposit " + productCost + " cents to buy " + items[selection - 1] + ": ");

                while (depositedAmount < productCost && tries < 2) {
                    int deposit = scanner.nextInt();
                    scanner.nextLine();

                    depositedAmount += deposit;
                    int remainingBalance = productCost - depositedAmount;

                    if (remainingBalance > 0) {
                        System.out.print("Please deposit " + remainingBalance + " more to buy: ");
                    } else {
                        int change = depositedAmount - productCost;
                        cashRegister.acceptAmount(productCost);
                        cashRegister.acceptAmount(-change);

                        for (int i = 1; i <= numOfItems; i++) {
                            selectedDispenser.makeSale();
                        }     
                        
                        System.out.println("Change returned: " + change + " cents");
                        System.out.println("\nEnjoy your " + items[selection - 1] + "!");
                        break;
                    }
                    tries++;
                }
                
                if (tries >= 2) {
                	System.out.println("\n\nTransaction canceled! Returning money");
                    cashRegister.acceptAmount(-depositedAmount);
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

            if (choice == 0) {
                isRunning = false;
                System.out.println("Thank you for using the Juice Machine. Have a great day!");
                System.out.println("Current Cash Register Balance: " + cashRegister.getCurrentBalance() + " cents");
                break;
            } else {
                System.out.print("How many will you buy? ");
                int numOfItems = scanner.nextInt();
                scanner.nextLine();

                sellProduct(choice, numOfItems);
            }
        }
    }
}
