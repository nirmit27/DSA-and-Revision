package LeetCode.Prefix;
/* 
LeetCode problem #649 solution
Link : https://leetcode.com/problems/minimize-xor/
 */

import java.util.Scanner;

public class minXOR {
    private static int setBitCount(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    private static int addSets(int n, int k) {
        int pos = 0;
        while (k > 0) {
            while ((n >> pos & 1) == 1)
                pos++;
            n |= 1 << pos;
            k--;
        }
        return n;
    }

    private static int remSets(int n, int k) {
        while (k > 0) {
            n &= n - 1;
            k--;
        }
        return n;
    }

    public static int minimizeXor(int n1, int n2) {
        int n1SBC = setBitCount(n1);
        int n2SBC = setBitCount(n2);

        if (n1SBC == n2SBC)
            return n1;

        if (n1SBC < n2SBC)
            return addSets(n1, n2SBC - n1SBC);
        return remSets(n1, n1SBC - n2SBC);
    }

    public static void main(String[] args) {
        int n1, n2;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the first number : ");
            n1 = sc.nextInt();
            System.out.print("Enter the second number : ");
            n2 = sc.nextInt();
        }
        System.out.println(String.format("\nMinimum XOR value : %d\n", minimizeXor(n1, n2)));
    }
}
