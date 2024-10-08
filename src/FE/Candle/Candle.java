package FE.Candle;

public class Candle {
	private String color;
	protected double height;
	protected double price;
	
	Candle(String color, double height) {
		this.color = color;
		this.height = height;
		setHeight(height);
	}

	public String getColor() {
		return color;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setHeight(double height) {
		this.height = height;
		this.price = height*2;
	}
}
