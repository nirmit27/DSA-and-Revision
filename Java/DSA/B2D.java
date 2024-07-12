/* Converting BIN to DEC */

import java.util.Scanner;

public class B2D {
    public static boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static int b2D(char[] input) {
        if (input.length == 0) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i < input.length; i++) {
            if (!isDigit(input[i])) {
                return -1;
            }
            res += Math.pow(2, (double) (input.length - i - 1)) * ((int) input[i] - 48);
        }
        return res;
    }

    public static void main(String[] args) {
        int dec;
        String input;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the BIN number : ");
            input = sc.nextLine();
        }

        dec = b2D(input.toCharArray());
        if (dec != -1) {
            System.out.println(String.format("\nBIN : %s  >>  DEC : %d", input, dec));
        } else {
            System.out.println(String.format("\nNo possible conversion for '%s' to a DEC number.", input));
        }
    }
}
