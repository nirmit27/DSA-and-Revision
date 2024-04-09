/* 3 Examples of Method Overloading i.e.
COMPILE-TIME or STATIC Polymorphism */

import java.lang.Math;

class Area {
    public int area(int l, int b) { // For a function named 'area' ...
        return l * b;
    }

    public double area(double l, double b) { // Params.' data TYPE changed
        return l * b;
    }

    public double area(double r) { // NUMBER of params. changed
        return Math.pow(r, 2) * 3.142;
    }
}

class Details {
    void show(String name, long urn) { // For this function ...
        System.out.println(String.format("%s : %d", name, urn));
    }

    void show(long urn, String name) { // ORDER of params. changed
        System.out.println(String.format("%s : %d", name, urn));
    }
}

public class Overloading {
    public static void main(String[] args) {
        Area a = new Area();
        System.out.println(a.area(2, 3));
        System.out.println(a.area(2.5, 3.7)); // Example 1
        System.out.println(a.area(2.0)); // Example 2

        // Use 'L' after 'long' type values for the compilation.

        Details d = new Details();
        d.show(2100560100064L, "Nirmit Mishra");
        d.show("Nirmit Mishra", 2100560100064L); // Example 3
    }
}
