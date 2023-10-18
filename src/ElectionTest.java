package AGU;

import java.text.DecimalFormat;

class Election {
	private String[] candidates;
	private int[] votes;
	
	Election() {
		this.candidates = new String[5];
		this.votes = new int[5];
	}
	
	Election(String[] candidates, int[] votes) {
		this.candidates = candidates;
		this.votes = votes;
	}
	
	public void setCandidates(String[] candidates) {
		this.candidates = candidates;
	}
	
	public void setVotes(int[] votes) {
		this.votes = votes;
	}
	
	public String[] getCandidates() {
		return candidates;
	}
	
	public int[] getVotes() {
		return votes;
	}
	
	public int calculateTotalVotes() {
		int totalVotes = 0 ;
		
		for (int vote : votes) {
			totalVotes += vote;
		}
		
		return totalVotes;
	}
	
	public double calculatePercentage(int candidateIndex) {
		int totalVotes = calculateTotalVotes();
		
		if (totalVotes == 0) {
			return 0.00;
		}
		double totalPercentage = ((double) votes[candidateIndex] / totalVotes) * 100;
		
		return Double.parseDouble(new DecimalFormat("0.00").format(totalPercentage));
	}
	
	public String getWinner() {
		String winner = candidates[0];
		
		for (int i = 0; i < votes.length-1; i++) {
			if (votes[i] < votes[i+1]) {
				winner = candidates[i+1];
			}
		}
		
		return winner;
	}
	
	public void displayTable() {
		System.out.println("Candidate \t\t Votes Received \t % of Total Votes");
		
		for (int i = 0; i < candidates.length; i++ ) {
			System.out.println(candidates[i] + "\t\t\t" + getVotes()[i] + "\t\t\t" + calculatePercentage(i));
		}
		System.out.println("The Winner of the Election is " + getWinner());
	}
}

public class ElectionTest {
	public static void main(String[] args) {
		String[] candidates = { "Johnson", "Miller", "Duffy", "Robinson", "Ashton" };
		int[] votes = { 5000, 4000, 6000, 2500, 1800 };
	
		Election election = new Election( candidates, votes);
		
		election.displayTable();
		
	}
}
