/* 
Counting the number of ROTATIONS in an array
Link : https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RotationCount {
    public static int rotations(ArrayList<Integer> arr) {
        if (arr.size() <= 1)
            return 0;
        
        int start = 0, end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr.get(mid) > arr.get(mid + 1)) {
                return mid + 1;
            }
            if (mid > start && arr.get(mid) < arr.get(mid - 1)) {
                return mid;
            } else if (arr.get(mid) <= arr.get(start)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) { // { 15, 18, 2, 3, 6, 12 } -> 2 rotations
        int size, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = rotations(arr);
        System.out.println(String.format("\nNo. of rotations : %d", result));
    }
}
