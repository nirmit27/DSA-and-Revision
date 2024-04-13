package CalcPack;

import java.text.DecimalFormat;

public class Calc2 {
    String pattern = "#.##"; // Upto 2 decimal places
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    public float multiply(int x, int y) {
        float res = x * y;
        return Float.parseFloat(decimalFormat.format(res));

    }

    public float divide(int x, int y) {
        float res = x / y;
        return Float.parseFloat(decimalFormat.format(res));
    }
}
