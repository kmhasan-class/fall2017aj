package bd.ac.seu.aj.parallelpi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PiCalculator {
    public static final BigDecimal FOUR = new BigDecimal(4);
    private BigDecimal result = BigDecimal.ZERO;

    private synchronized void addResult(BigDecimal otherResult) {
        result = result.add(otherResult);
    }

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

    private BigDecimal getPiBigDecimal(long start, long terms) {
        BigDecimal sum = BigDecimal.ZERO;
        for (long t = start; t <= start + terms; t++) {
            long denominator = 2 * t - 1;
            if (t % 2 == 0)
                sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
            else sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
        }
        return sum.multiply(FOUR);
    }

    public BigDecimal getPiParallel(long terms, int cores) {
        result = BigDecimal.ZERO;
        Thread threads[] = new Thread[cores];

        // Hometask: fix this part where the number of terms is not divisible by cores
        // Hometask: rewrite this as lambdas (without threads) and streams and use parallel streams
        // Hometask: read up on Executor Framework and see how you can submit the tasks and get the results back
        long termParts = terms / cores;
        for (int i = 0; i < cores; i++) {
            long startTerm = 1 + (terms * i / cores);
            threads[i] = new Thread(() -> {
                BigDecimal result1 = getPiBigDecimal(startTerm, termParts);
                addResult(result1);
            });
            threads[i].start();
        }
        for (Thread thread : threads)
            try {
                thread.join();
            } catch (InterruptedException ie) {
                System.err.println(ie.toString());
            }
        /*
        Thread thread1 = new Thread(() -> {
            BigDecimal result1 = getPiBigDecimal(1, terms / 2);
            addResult(result1);
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            BigDecimal result2 = getPiBigDecimal(terms / 2 + 1, terms / 2);
            addResult(result2);
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
*/
        return result;
    }
}
