package LE_6_1.LE_6_13;

public class Cake {
    protected String name;
    protected double rate;

    Cake(String n, double r) {
        this.name = n;
        this.rate = r;
    }

    public String getCakeName() {
        return this.name;
    }

    public double getRate() {
        return this.rate;
    }

    public double calcPrice() {
        return 0;
    }

    public String toString() {
        return "Cake: " + name + "\tRate: " + rate;
    }

}
