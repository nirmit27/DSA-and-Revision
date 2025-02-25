package LeetCode.Stack;
/* 
LeetCode problem #32 solution
Link : https://leetcode.com/problems/longest-valid-parentheses/
 */

import java.util.Stack;

public class LongestValidPara {
    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                st.pop();

                if (st.isEmpty())
                    st.push(i);
                else
                    ans = Math.max(ans, i - st.peek());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
