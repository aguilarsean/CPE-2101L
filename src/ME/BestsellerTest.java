import java.text.DecimalFormat;

class Bestseller {
	private String[] books;
	private int[] sales;
	
	public Bestseller() {
		this.books = new String[5];
		this.sales = new int[5];
	}
	
	public Bestseller(String[] books, int[] sales) {
		this.books = books;
		this.sales = sales;
	}
	
	public void setBooks(String[] book) {
		this.books = book;
	}
	
	public void setSales(int[] sale) {
		this.sales = sale;
	}
	
	public String[] getBooks() {
		return books;
	}
	
	public int[] getSales() {
		return sales;
	}
	
	public int calculateTotalSales() {
		int totalSales = 0 ;
		
		for (int sale : sales) {
			totalSales += sale;
		}
		
		return totalSales;
	}
	
	public double calculatePercentage(int bookIndex) {
		int totalSales= calculateTotalSales();
		
		if (totalSales == 0) {
			return 0.00;
		}
		double totalPercentage = ((double) sales[bookIndex] / totalSales) * 100;
		
		return Double.parseDouble(new DecimalFormat("0.00").format(totalPercentage));
	}
	
	public String getBestSeller() {
		String bestSeller = "";
		
		for (int i = 0; i < books.length-1; i++) {
			if (sales[i] < sales[i+1]) {
				bestSeller = books[i+1];
			} else {
				bestSeller = books[i];
			}
		}
		
		return bestSeller;
	}
	
	public void displayTable() {
		System.out.println("Books \t\t\t\t\t Sales Received \t % of Total Sales");
		
		for (int i = 0; i < books.length; i++ ) {
//			System.out.println(books[i] + "\t\t\t\t" + getSales()[i] + "\t\t\t" + calculatePercentage(i));
			System.out.printf("%-40s %-15s %13s\n", books[i], getSales()[i], calculatePercentage(i));
		}
		System.out.println("Total \t\t\t\t\t " + calculateTotalSales());
		System.out.println("\nThe Bestseller book is " + getBestSeller() + ".");
	}
}

public class BestsellerTest {
	public static void main(String[] args) {
		String[] books = { "batman", "superman", "wonder woman", "iron man", "aquaman" };
		int[] sales = {  115, 170, 110, 75, 165 };
	
		Bestseller bestseller = new Bestseller(books, sales);
		
		bestseller.displayTable();
		
	}
}
