package LE_4_1;

public class RectangleMain {
	public static void main(String[] args) {
        Rectangle rectangleOne = new Rectangle(4, 40);
        Rectangle rectangleTwo = new Rectangle(3.5, 35.9);

        System.out.println("\nRectangle 1:" + "\n\twidth - " +
                rectangleOne.getWidth() + "\n\theight - " +
                rectangleOne.getHeight() + "\n\tarea - " +
                rectangleOne.getArea() + "\n\tperimeter - " +
                rectangleOne.getPerimeter());

        System.out.println("\nRectangle 2:" + "\n\twidth - " +
                rectangleTwo.getWidth() + "\n\theight - " +
                rectangleTwo.getHeight() + "\n\tarea - " +
                rectangleTwo.getArea() + "\n\tperimeter - " +
                rectangleTwo.getPerimeter());
    }
}

class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
    	return width;
    }
    
    public double getHeight() {
    	return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
