package GfG.Stack;
/*
GfG problem - "Get Min from Stack" solution
Link : https://www.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
 */

import java.util.Stack;

public class SpecialStack {
    private int minE;
    private Stack<Integer> st;

    // Constructor definition
    public SpecialStack() {
        st = new Stack<>();
        minE = Integer.MIN_VALUE;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        if (st.isEmpty()) {
            minE = x;
            st.push(x);
        } else if (x < minE) {
            st.push(2 * x - minE); // Push an ENCODED value of 'x' to the stack
            minE = x;
        } else
            st.push(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        if (st.isEmpty())
            return;

        int top = st.pop();
        if (top < minE)
            minE = 2 * minE - top; // Fetching the PREVIOUS minimum element
    }

    // Returns top element of the Stack
    public int peek() {
        if (st.isEmpty())
            return -1;

        int top = st.peek();
        return (minE > top) ? minE : top;
    }

    // Finds minimum element of Stack in O(1) time
    public int getMin() {
        if (st.isEmpty())
            return -1;
        return minE;
    }
}
