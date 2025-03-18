package GfG.DP;
/* 
GfG problem - "Longest String Chain" solution
Link : https://www.geeksforgeeks.org/problems/longest-string-chain/1
 */

import java.util.Arrays;
import java.util.HashMap;

public class LongStringChain {
    public static int longestStringChain(String words[]) {
        String pred;
        int ans = 1;
        HashMap<String, Integer> dp = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            dp.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                pred = word.substring(0, i) + word.substring(i + 1);

                if (dp.containsKey(pred))
                    dp.put(word, Math.max(dp.get(word), dp.get(pred) + 1));
            }
            ans = Math.max(ans, dp.get(word));
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
