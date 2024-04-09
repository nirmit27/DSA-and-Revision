import java.lang.System;
import java.lang.String;

class Sum {
    public static void main(String args[]) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(String.format("\n%d + %d = %d\n", a, b, (a + b)));
    }
}