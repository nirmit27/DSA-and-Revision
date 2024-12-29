/**
 * Patterns
 */

import java.util.Scanner;

public class Patty {
    static void triangle(int rows, int cols, int limit) {
        if (rows == limit)
            return;
        if (cols <= rows) {
            System.out.print("* ");
            triangle(rows, cols + 1, limit);
        } else {
            System.out.println();
            triangle(rows + 1, 0, limit);
        }
    }

    static void invTriangle(int rows, int cols) {
        if (rows == 0)
            return;
        if (cols < rows) {
            System.out.print("* ");
            invTriangle(rows, cols + 1);
        } else {
            System.out.println();
            invTriangle(rows - 1, 0);
        }
    }

    public static void main(String[] args) {
        int rows;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of rows : ");
            rows = sc.nextInt();
        }
        System.out.println();
        triangle(0, 0, rows + 1);
        invTriangle(rows, 0);
    }
}