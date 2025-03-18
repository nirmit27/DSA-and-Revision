package GfG.DP;
/* 
GfG problem - "Edit Distance" solution
Link : https://www.geeksforgeeks.org/problems/edit-distance3702/1
 */

public class EditDistance {
    public static int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // For the first row ...
        for (int i = 0; i <= n; i++)
            prev[i] = i;

        // For the subsequent rows ...
        for (int i = 1; i <= m; i++) {
            curr[0] = i;

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j], prev[j - 1]));
            }
            prev = curr.clone();
        }
        return prev[n];
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
