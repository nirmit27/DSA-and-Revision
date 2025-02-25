package GfG.Stack;
/* 
GfG problem - "k largest elements" solution
Link : https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
 */

import java.util.Stack;
// import java.util.Scanner;

public class MaxHistArea {
    public static int maxHistArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length, res = 0, top, temp;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                top = st.pop();
                res = Math.max(res, arr[top] * (st.isEmpty() ? i : i - st.peek() - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            top = st.pop();
            temp = arr[top] * (st.isEmpty() ? n : n - st.peek() - 1);

            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: Implement the 'main' method
    }
}
