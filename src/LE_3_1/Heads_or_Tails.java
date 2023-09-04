package LE_3_1;

public class Heads_or_Tails {
	public static void main(String[] args) {
		int heads = 0;
		int tails = 0;
		
		for (int i = 0; i < 2000000; i++) {
			int flip = (int) (Math.random() * 2);
			if (flip == 1) {
				heads++;
			} else {
				tails++;
			}
		}
		System.out.println("Heads: " + heads);
		System.out.println("Tails: " + tails);
	}
}
