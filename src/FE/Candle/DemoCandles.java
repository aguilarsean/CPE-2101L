package FE.Candle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DemoCandles {
	private static ArrayList<Candle> candles = new ArrayList<>();
	
	public static void initCandles() {
		candles.add(new ScentedCandle("Red", 3, "Vanilla"));
		candles.add(new ScentedCandle("Red", 5, "Rose"));
		candles.add(new ScentedCandle("Red", 10, "Black Forest"));
		candles.add(new Candle("White", 2));
		candles.add(new Candle("White", 4));
	}
	
	public static void displayCandles() {
		System.out.println("\nCandles");
		for (Candle candle : candles) {
			if (candle instanceof Candle && !(candle instanceof ScentedCandle)) {
				System.out.println("Color: " + candle.getColor() + " Height: " + candle.getHeight() + " Price: " + candle.getPrice());
			}
		}
	}
	
	public static void displayScentedCandles() {
		System.out.println("\nScented Candles");
		for (Candle candle : candles) {
			if (candle instanceof ScentedCandle) {
				System.out.println("Scent: " + ((ScentedCandle) candle).getScent() + " Color: " + candle.getColor() + " Height: " + candle.getHeight() + " Price: " + candle.getPrice());
			}
		}
	}
	
	public static void main(String[] args) {
		initCandles();
		displayCandles();
		displayScentedCandles();
		
		double total = 0;
		
		for (Candle candle : candles) {
			total+=candle.getPrice();
		}

		System.out.println("\nTotal Price: " + total);
	}
}
