package bd.ac.seu.aj.parallelpi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PiCalculator {
    public static final BigDecimal FOUR = new BigDecimal(4);

    public double getPi(long terms) {
        double sum = 0;
        for (long t = 1; t <= terms; t++) {
            long denominator = 2 * t - 1;
            if (t % 2 == 0)
                sum = sum - 1.0 / denominator;
            else sum = sum + 1.0 / denominator;
        }
        return sum * 4;
    }

    public BigDecimal getPiBigDecimal(long terms) {
        BigDecimal sum = BigDecimal.ZERO;
        for (long t = 1; t <= terms; t++) {
            long denominator = 2 * t - 1;
            if (t % 2 == 0)
                sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
            else sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
        }
        return sum.multiply(FOUR);
    }

    public BigDecimal getPiBigDecimal(long start, long terms) {
        BigDecimal sum = BigDecimal.ZERO;
        for (long t = start; t <= start + terms; t++) {
            long denominator = 2 * t - 1;
            if (t % 2 == 0)
                sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
            else sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
        }
        return sum.multiply(FOUR);
    }
}
