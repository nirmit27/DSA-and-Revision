/* 
Finding the PIVOT element in a Rotated Sorted array
Explanation : https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=10395s
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Pivot {
    public static int findPivot(ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr.get(mid) > arr.get(mid + 1)) { // Case 1
                return mid;
            }
            if (mid > start && arr.get(mid) < arr.get(mid - 1)) { // Case 2
                return mid - 1;
            } else if (arr.get(mid) <= arr.get(start)) { // Case 3
                end = mid - 1;
            } else { // Case 4
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int size, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = findPivot(arr);
        if (result != -1) {
            System.out.println(String.format("\nPivot element %d found at index : %d", arr.get(result), result));
        } else {
            System.out.println("\nPivot element not found.");
        }
    }
}
