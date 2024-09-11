/* 
LeetCode problem #2220 solution
Link : https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 */

import java.util.Scanner;

class BitFlips {
    public static void main(String[] args) {
        int a, b, res;
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("\nEnter the target : ");
            a = sc.nextInt();
            System.out.print("\nEnter the goal : ");
            b = sc.nextInt();
        }
        res = Integer.bitCount(a ^ b);
        System.out.println(String.format("\nNo. of bit flips required : %d", res));
    }
}
