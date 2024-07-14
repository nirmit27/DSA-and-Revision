/* 
LeetCode problem #118 solution - Pascal's Triangle
Link : https://leetcode.com/problems/pascals-triangle/
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Pascal {
    public static void displayTriangle(List<List<Integer>> triangleRows) {
        if (triangleRows.size() == 0)
            return;
        if (triangleRows.size() == 1) {
            System.out.println(String.format("\nPascal's triangle with 1 row :\n"));
            System.out.println(1 + "\n");
        }

        int numRows = triangleRows.size();
        System.out.println(String.format("\nPascal's triangle with %d rows :\n", numRows));
        
        for (int i = 0; i < triangleRows.size(); i++) {
            System.out.print(" ".repeat(numRows - i));
            for (int j = 0; j < triangleRows.get(i).size(); j++) {
                System.out.print(triangleRows.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();

        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }

        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> newRow = new ArrayList<>();

        for (int i = 0; i < numRows; i++)
            newRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            newRow.set(i, prevRows.get(numRows - 2).get(i) + prevRows.get(numRows - 2).get(i - 1));
        }

        prevRows.add(newRow);
        return prevRows;
    }

    public static void main(String[] args) {
        int rows;
        List<List<Integer>> triangleRows = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of rows : ");
            rows = sc.nextInt();
        }
        triangleRows = generate(rows);
        displayTriangle(triangleRows);
    }
}
