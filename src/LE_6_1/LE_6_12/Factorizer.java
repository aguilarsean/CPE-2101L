package LE_6_1.LE_6_12;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Factorizer {
    protected ArrayList<Integer> factors;

    /**
     * Calculate factors of an integer.
     *
     * @param m = The integer to factorize.
     */
    public abstract void getFactors(int m);

    /**
     * Finds the smallest number to make the product a perfect square.
     *
     * @return The smallest number.
     */
    protected int getSmallestNumber() {
        // Create a copy of factors to manipulate occurrences without modifying the original list.
        int[][] occurrences = copy(factors);
        for (int i : factors) {
            search(occurrences, i);
        }

        // Filter factors that have odd occurrences.
        ArrayList<Integer> oddSequenceFactors = removeDuplicates(occurrences);

        int smallestSquare = 1;
        for (int i : oddSequenceFactors) {
            smallestSquare *= i;
        }
        return smallestSquare;
    }

    /**
     * Copies the list of factors into a 2D array for operations.
     *
     * @param factors = The list of factors.
     * @return A 2D array copy of the factors.
     */
    protected int[][] copy(ArrayList<Integer> factors) {
        int[][] temp = new int[factors.size()][2];
        for (int i = 0; i < temp.length; i++) {
            temp[i][0] = factors.get(i);
        }
        return temp;
    }

    /**
     * Search and increment the occurrence count of a factor in the occurrences array.
     *
     * @param m = The 2D array of factors and their occurrences.
     * @param number = The factor to search and update.
     */
    protected void search(int[][] m, int number) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == number) {
                m[i][1]++;
            }
        }
    }

    /**
     * Remove duplicate factors and only keep factors with odd occurrences.
     *
     * @param m = The 2D array of factors and their occurrences.
     * @return A list of unique factors with odd occurrences.
     */
    protected ArrayList<Integer> removeDuplicates(int[][] m) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            if (m[i][1] % 2 != 0) {
                temp.add(m[i][0]);
            }
        }

        ArrayList<Integer> duplicateRemoved = new ArrayList<>();
        for (Integer integer : temp) {
            if (!duplicateRemoved.contains(integer)) {
                duplicateRemoved.add(integer);
            }
        }

        return duplicateRemoved;
    }
}
