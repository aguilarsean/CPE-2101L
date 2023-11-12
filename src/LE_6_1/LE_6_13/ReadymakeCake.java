package LE_6_1.LE_6_13;

public class ReadymakeCake extends Cake {
    protected int quantity;

    ReadymakeCake(String n, double r, int q) {
        super(n, r);
        this.quantity = q;
    }

    public double calcPrice() {
        return super.rate*quantity;
    }

    public String toString() {
        return super.toString() + "\tPrice: " + calcPrice();
    }
}
