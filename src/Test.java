import java.util.Scanner;

public class Test {
    private int x;

    Test(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        Test obj1 = new Test(5);
        Test obj2 = new Test(15);

        System.out.println(obj1.x);
        System.out.println(obj2.x);
    }
}
