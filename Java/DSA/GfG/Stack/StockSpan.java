package GfG.Stack;
/* 
GfG problem - "Stock span problem" solution
Link : https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
 */

import java.util.Stack;
// import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class StockSpan {
    public static ArrayList<Integer> stockSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()])
                st.pop();

            if (!st.isEmpty())
                ans.set(i, i - st.peek());
            else
                ans.set(i, i + 1);

            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO: Implement the 'main' method
    }
}
