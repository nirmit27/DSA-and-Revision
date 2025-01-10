package LeetCode;
/* 
LeetCode problem #744 solution
Link : https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class CeilCharacter {
    static char ceilChar(ArrayList<Character> arr, char ch) {
        if (arr == null || arr.size() == 0) {
            return (char) 0;
        }
        int start = 0, end = arr.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (ch < arr.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr.get(start % arr.size());
    }

    public static void main(String[] args) {
        int size;
        char ch, result;
        ArrayList<Character> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            System.out.print("\nEnter the characters : ");
            for (int i = 0; i < size; i++) {
                char x = sc.next().charAt(0);
                arr.add(x);
            }
            System.out.print("\nEnter the target character : ");
            ch = sc.next().charAt(0);
        }

        result = ceilChar(arr, ch);
        if (result != '\u0000') {
            System.out.println(String.format("\nCeil character for %c : %c", ch, result));
        } else {
            System.out.println(String.format("\nCeil character for %c does not exist in the array.", ch));
        }
    }
}
