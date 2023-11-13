package LE_6_1.LE_6_13;

public class OrderCake extends Cake {
    protected double weight;
    private double price;

    OrderCake(String n, double r, double w) {
        super(n, r);
        this.weight = w;
    }

    public double getWeight() {
        return this.weight;
    }

    public double calcPrice() {
        return weight*super.rate;
    }

    public String toString() {
        return super.toString() + "\tPrice: " + calcPrice();
    }

}
