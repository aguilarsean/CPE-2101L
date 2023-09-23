package LE_3_2;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"write", "that", "program"};
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            HangmanGame game = new HangmanGame(words, scanner);
            game.play();

            System.out.print("Do you want to guess another word? Enter y or n > ");
            String playAgainInput = scanner.nextLine().toLowerCase();

            if (!playAgainInput.equals("y")) {
                playAgain = false;
            }
            System.out.println();
        }

        scanner.close();
    }
}

class HangmanGame {
    private final String[] words;
    private final Scanner scanner;
    private String chosenWord;
    private StringBuilder currentGuess;
    private StringBuilder guessedLetters;
    private int misses;

    public HangmanGame(String[] words, Scanner scanner) {
        this.words = words;
        this.scanner = scanner;
    }

    public void play() {
        initializeGame();

        while (currentGuess.indexOf("*") != -1) {
            System.out.print("(Guess) Enter a letter in word " + currentGuess + " > ");
            char guess = scanner.nextLine().charAt(0);
            guess = Character.toLowerCase(guess);

            if (guessedLetters.indexOf(String.valueOf(guess)) != -1) {
                System.out.println("\t" + guess + " is already in the word.");
            } else {
                updateGame(guess);
            }
        }

        displayGameResult();
    }

    private void initializeGame() {
        chosenWord = words[new Random().nextInt(words.length)];
        currentGuess = new StringBuilder(chosenWord.length());
        guessedLetters = new StringBuilder();
        misses = 0;

        for (int i = 0; i < chosenWord.length(); i++) {
            currentGuess.append('*');
        }
    }

    private void updateGame(char guess) {
        guessedLetters.append(guess);
        boolean found = false;

        for (int i = 0; i < chosenWord.length(); i++) {
            if (chosenWord.charAt(i) == guess) {
                currentGuess.setCharAt(i, guess);
                found = true;
            }
        }

        if (!found) {
            System.out.println("\t" + guess + " is not in the word.");
            misses++;
        }
    }

    private void displayGameResult() {
        System.out.println("The word is " + chosenWord + ". You missed " + misses + " time(s).");
    }
}

