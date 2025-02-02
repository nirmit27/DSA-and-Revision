package GfG.Backtracking;
/* 
GfG problem - "Word Search" solution
Link : https://www.geeksforgeeks.org/problems/word-search/1
 */

import java.util.Scanner;

public class WordSearch {
    private static int rows;
    private static int cols;
    private static int len;

    // DFS Approach
    private static boolean dfs(int i, int j, char[][] mat, String s, int index) {
        // BASE CASE : All characters matched
        if (index == len)
            return true;

        // Terminal CASE : Index out of bounds || non-matching character found
        if (i < 0 || i >= rows || j < 0 || j >= cols || s.charAt(index) != mat[i][j])
            return false;

        // STEP 1 : SELECT the current cell character and mark it as '#'
        char temp = mat[i][j];
        mat[i][j] = '#';

        // STEP 2 : MOVE in any of the possible directions
        boolean res = dfs(i + 1, j, mat, s, index + 1) || dfs(i - 1, j, mat, s, index + 1) ||
                dfs(i, j + 1, mat, s, index + 1) || dfs(i, j - 1, mat, s, index + 1);

        // STEP 3 : BACKTRACK - Restore the previous character
        mat[i][j] = temp;
        return res;
    }

    public static boolean isWordExist(char[][] mat, String s) {
        len = s.length();
        rows = mat.length;
        cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // For every cell matching FIRST character of the string ...
                if (mat[i][j] == s.charAt(0)) {
                    if (dfs(i, j, mat, s, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n, m;
        char[][] mat;
        String word;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of rows : ");
            n = sc.nextInt();
            System.out.print("Enter the number of columns : ");
            m = sc.nextInt();

            mat = new char[n][m];
            System.out.println("\nEnter the elements of the matrix : ");
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    mat[i][j] = sc.next().charAt(0);

            System.out.print("\nEnter the word to search : ");
            word = sc.next();
        }
        System.out.println("\nThe word '" + word + (isWordExist(mat, word) ? "' exists!" : "' does NOT exist!") + "\n");
    }
}
