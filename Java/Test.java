/* Example of User-defined packages */

import CalcPack.*; // Importing the classes of a user-defined package 'CalcPack'
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int x, y;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the first number : ");
            x = sc.nextInt();
            System.out.print("\nEnter the second number : ");
            y = sc.nextInt();
        }

        Calc1 c1 = new Calc1(); // Instantiating the FIRST packaged class
        Calc2 c2 = new Calc2(); // Instantiating the SECOND packaged class

        System.out.println(String.format("\n%d + %d = %d", x, y, c1.add(x, y)));
        System.out.println(String.format("\n%d * %d = %.2f", x, y, c2.multiply(x, y)));
        System.out.println();
    }
}
