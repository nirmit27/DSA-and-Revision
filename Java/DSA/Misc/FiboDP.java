package Misc;
/* Dynamic Programming approach for generating Fibonacci sequence */

import java.util.Scanner;
import java.util.HashMap;

class FiboDP {
    public static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fiboTD(int n) { // Memoization
        if (n < 2)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);

        int result = fiboTD(n - 1) + fiboTD(n - 2);
        memo.put(n, result);
        return result;
    }

    public static int fiboBU(int n) { // Tabulation
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }

    public static void main(String[] args) {
        int limit;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the limit : ");
            limit = sc.nextInt();
        }
        System.out.println(String.format("\nFibonacci sequence upto %dth term :", limit));
        for (int i = 1; i < limit + 1; i++)
            System.out.print(fiboBU(i) + " ");
    }
}