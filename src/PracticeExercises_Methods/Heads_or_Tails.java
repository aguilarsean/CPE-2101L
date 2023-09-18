package PracticeExercises_Methods;

public class Heads_or_Tails {
	public static int[] getCount() {
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
		
		int[] count = {heads, tails};
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] count = getCount();
		
		System.out.println("Heads: " + count[0]);
		System.out.println("Tails: " + count[1]);
	}
}
