package GfG.Greedy;
/* 
GfG problem - "Maximize partitions in a String" solution
Link : https://www.geeksforgeeks.org/problems/maximize-partitions-in-a-string/1
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPartitions {
    public int maxPartitions(String s) {
        // dealing with the trivial cases
        if (s.length() <= 2)
            return (s.length() == 1) ? 1 : (s.charAt(0) != s.charAt(1)) ? 2 : 1;

        int n = s.length(), rb = 0, partitions = 0;
        Map<Character, Integer> rbMap = new HashMap<>();

        for (int i = 0; i < n; i++)
            rbMap.put(s.charAt(i), i); // compute the last/rightmost occurence of any character

        for (int i = 0; i < n; i++) {
            rb = Math.max(rb, rbMap.get(s.charAt(i))); // determine the rightmost boundary for any character

            if (rb == i)
                partitions++; // increment partitions when last occurence of a character is encountered
        }
        return partitions;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
