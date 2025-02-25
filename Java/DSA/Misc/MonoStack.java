/* Problems and their solutions using the Monotonic Stack */

import java.util.Stack;
import java.util.Scanner;

public class MonoStack {
    // Problem #1 : Finding the NEXT GREATER element
    public static int[] nge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    // Problem #2 : Finding the PREVIOUS SMALLER element
    public static int[] pse(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i])
                st.pop();

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int n;
        int[] arr, prev, next;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        prev = pse(arr);
        next = nge(arr);

        System.out.print("\nPrevious Smaller elements : [ ");
        for (int pr : prev)
            System.out.print(pr + " ");
        System.out.println("]");

        System.out.print("\nNext Greater elements : [ ");
        for (int ne : next)
            System.out.print(ne + " ");
        System.out.println("]\n");
    }
}
