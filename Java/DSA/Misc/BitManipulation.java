/* Fundamentals of Bit Manipulation */

import java.util.Scanner;

public class BitManipulation {
    public static String decToBin(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            if ((n & 1) == 1)
                res.append('1');
            else
                res.append('0');
            n >>= 1;
        }
        return res.reverse().toString();
    }
    
    public static int updateBit(int n, int pos) {
        if (pos < 1)
            return n;
        switch(getBit(n, pos)) {
            case 1: return clearBit(n, pos);
            case 0: return setBit(n, pos);
            default: return n;
        }
    }
    
    public static int clearBit(int n, int pos) {
        if (pos < 1)
            return n;
        int mask = 1 << (pos - 1);
        return n & ~mask;
    }
    
    public static int setBit(int n, int pos) {
        if (pos < 1)
            return n;
        int mask = 1 << (pos - 1);
        return n | mask;
    }
    
    public static int getBit(int n, int pos) {
        if (pos < 1)
            return 0;
        int mask = 1 << (pos - 1);
        return (n & mask) != 0 ? 1 : 0;
    }
    
    public static void main(String[] args) {
        int n, pos;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number : ");
            n = sc.nextInt();
            System.out.print("Enter the bit position : ");
            pos = sc.nextInt(); // 1-based indexing
        }
        System.out.println(String.format("\nGetting bit #%d of %d : %d", pos, n, getBit(n, pos)));
        System.out.println(String.format("Setting bit #%d of %d : %d", pos, n, setBit(n, pos)));
        System.out.println(String.format("Clearing bit #%d of %d : %d", pos, n, clearBit(n, pos)));
        System.out.print(String.format("Updating %s at position %d : %s", decToBin(n), pos, decToBin(updateBit(n, pos))));
    }
}