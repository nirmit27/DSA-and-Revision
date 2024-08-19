/* 
GfG problem - "Number of Occurrence" solution
Link : https://www.geeksforgeeks.org/problems/number-of-occurrence2259/0
 */

import java.util.Arrays;
import java.util.Scanner;

public class Count {
    public static int count(int[] arr, int n, int x) {
        if (n == 0)
            return 0;

        int start = 0;
        int end = n - 1;

        int count = 0;
        int mid = start + (end - start) / 2;

        int first = Integer.MIN_VALUE;
        int last = 0;

        while (start <= end) { // Locating the first occurence
            if (arr[mid] == x) {
                first = mid;
                end = mid - 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        start = 0;
        end = n - 1;
        mid = start + (end - start) / 2;

        while (start <= end) { // Locating the last occurence
            if (arr[mid] == x) {
                last = mid;
                start = mid + 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        count = last - first + 1;
        return (count < 0) ? 0 : count;
    }

    public static void main(String[] args) {
        int[] arr;
        int size, x, result;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            arr = new int[size];

            System.out.print("\nEnter the key : ");
            x = sc.nextInt();

            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // sorting in ASC order for BIN Search
        result = count(arr, arr.length, x);
        System.out.println(String.format("\nOccurrences of %d : %d", x, result));
    }
}
