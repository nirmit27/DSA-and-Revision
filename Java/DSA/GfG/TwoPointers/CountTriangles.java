package GfG.TwoPointers;
/* 
GfG problem - "Count the number of possible triangles" solution
Link : https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class CountTriangles {
    public static int countTriangles(int[] arr) {
        if (arr.length < 3)
            return 0;

        Arrays.sort(arr);
        if (arr.length == 3)
            if (arr.length == 3)
                return arr[0] + arr[1] > arr[2] ? 1 : 0;

        int left = -1, right = -1, count = 0;

        for (int i = 2; i < arr.length; i++) {
            left = 0;
            right = i - 1;

            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    count += right - left;
                    right--;
                } else
                    left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n, res;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the lengths of the sides : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = countTriangles(arr);
        System.out.println(String.format("\n%s",
                res == 0 ? "No triangles possible\n" : String.format("Possible number of triangles : %d\n", res)));
    }
}
