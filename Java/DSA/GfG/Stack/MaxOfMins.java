package GfG.Stack;
/* 
GfG problem - "Maximum of minimum for every window size" solution
Link : https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1
 */

import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MaxOfMins {
    public static ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length, windowSize, top;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> aux = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        // Step #1.1
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                top = st.pop();
                windowSize = st.isEmpty() ? i : i - st.peek() - 1;
                aux.set(top, windowSize);
            }
            st.push(i);
        }

        // Step #1.2
        while (!st.isEmpty()) {
            top = st.pop();
            windowSize = st.isEmpty() ? n : n - st.peek() - 1;
            aux.set(top, windowSize);
        }

        // Step #2.1
        for (int i = 0; i < n; i++) {
            windowSize = aux.get(i) - 1;
            ans.set(windowSize, Math.max(ans.get(windowSize), arr[i]));
        }

        // Step #2.2
        for (int i = n - 2; i >= 0; i--)
            ans.set(i, Math.max(ans.get(i), ans.get(i + 1)));
        return ans;
    }

    public static void main(String[] args) {
        int n;
        int[] arr;
        ArrayList<Integer> res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the array : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = maxOfMins(arr);
        System.out.println(String.format("\nMaximum of minimum for every window size : %s", res));
    }
}
