package LE_3_2;

import java.util.Random;

public class CrapsGame {
    private final Dice dice;

    public static void main(String[] args) {
        CrapsGame crapsGame = new CrapsGame();
        crapsGame.play();
    }

    public CrapsGame() {
        dice = new Dice();
    }

    public void play() {
        int point, sum;

        int[] diceValues = dice.rollDice();
        int dice1 = diceValues[0];
        int dice2 = diceValues[1];

        sum = dice1 + dice2;
        System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);

        if (sum == 7 || sum == 11) {
            System.out.println("You win\n");
        } else if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose\n");
        } else {
            point = sum;
            System.out.println("point is " + point);

            do {
                diceValues = dice.rollDice();
                dice1 = diceValues[0];
                dice2 = diceValues[1];
                sum = dice1 + dice2;
                System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
            } while (sum != 7 && sum != point);

            if (sum == point) {
                System.out.println("You win\n");
            } else {
                System.out.println("You lose\n");
            }
        }
    }
}

class Dice {
    Random randomNumbers;

    public Dice() {
        randomNumbers = new Random();
    }

    public int[] rollDice() {
        int dice1 = randomNumbers.nextInt(6) + 1;
        int dice2 = randomNumbers.nextInt(6) + 1;

        return new int[] {dice1, dice2};
    }
}
