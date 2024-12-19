package GfG;
/* 
GfG problem - "Koko Eating Bananas" solution
Link : https://www.geeksforgeeks.org/problems/koko-eating-bananas/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class KokoBananas {
    private static boolean checkSpeed(int[] arr, int speed, int k) {
        int hours = 0, d = 0;
        
        for (int hour : arr) {
            d = hour / speed;
            if (hour % speed != 0)
                hours++;
            hours += d;
        }
        return hours <= k;
    }
    
    public static int kokoEat(int[] arr, int k) {
        int low = 1, high = Arrays.stream(arr).max().getAsInt();
        int mid = low + (high - low) / 2, res = Integer.MAX_VALUE;
        
        while (low <= high) {
            if (checkSpeed(arr, mid, k)) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else
                low = mid + 1;
            mid = low + (high - low) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles;
        int size, limit;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of piles : ");
            size = sc.nextInt();
            piles = new int[size];

            System.out.print("\nEnter the banana count of piles : ");
            for (int i = 0; i < size; i++)
                piles[i] = sc.nextInt();
            
            System.out.print("\nEnter the hour limit : ");
            limit = sc.nextInt();
        }
        System.out.println(String.format("\nHours needed : %d", kokoEat(piles, limit)));
    }
}
