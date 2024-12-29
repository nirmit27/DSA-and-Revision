package GfG.Strings;
/* Utility functions for implementing the KMP algorithm */

public class StringUtils {
    static int[] computeLps(String s) {
        int[] lps = new int[s.length()];
        int i = 1, l = 0;
        lps[0] = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(l)) {
                l++;
                lps[i] = l;
                i++;
            } else {
                if (l != 0)
                    l = lps[l - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        // TODO: C'mon, do something :P
    }
}
