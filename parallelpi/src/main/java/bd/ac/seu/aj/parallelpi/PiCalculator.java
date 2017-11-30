package bd.ac.seu.aj.parallelpi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PiCalculator {
    public static final BigDecimal FOUR = new BigDecimal(4);
    private BigDecimal result = BigDecimal.ZERO;
    private long termParts;
    private int resultSum;

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

    public BigDecimal getPiParallel(long terms, int threads) {
        result = BigDecimal.ZERO;
        Thread threadArray[] = new Thread[threads];

        // Hometask #1: fix this part where the number of terms is not divisible by cores
        // Hometask #2: rewrite this as lambdas (without threads) and streams and use parallel streams
        // Hometask #3: read up on Executor Framework and see how you can submit the tasks and get the results back
        termParts = terms / threads;
        long remaining = terms % threads;
        for (int i = 0; i < threads; i++) {
            long startTerm = 1 + (terms * i / threads);
            if (i == threads - 1)
                termParts = termParts + remaining;
            threadArray[i] = new Thread(() -> {
                BigDecimal result1 = getPiBigDecimal(startTerm, termParts);
                addResult(result1);
            });
            threadArray[i].start();
        }
        for (Thread thread : threadArray)
            try {
                thread.join();
            } catch (InterruptedException ie) {
                System.err.println(ie.toString());
            }
        return result;
    }

    public BigDecimal getPiExecutorRunnable(long terms, int threads) {
        result = BigDecimal.ZERO;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        termParts = terms / threads;
        long remaining = terms % threads;
        for (int i = 0; i < threads; i++) {
            long startTerm = 1 + (terms * i / threads);
            if (i == threads - 1)
                termParts = termParts + remaining;

            executorService.submit(() -> {
                BigDecimal result1 = getPiBigDecimal(startTerm, termParts);
                addResult(result1);
            });
        }
        executorService.shutdown();
        System.out.println("Done with thread submission");
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with all the threads " + executorService.isTerminated());
        System.out.println(result);
        return result;
    }

    public BigDecimal getPiExecutorCallable(long terms, int threads) {
        result = BigDecimal.ZERO;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        Future<BigDecimal> futures[] = new Future[threads];

        termParts = terms / threads;
        long remaining = terms % threads;
        for (int i = 0; i < threads; i++) {
            long startTerm = 1 + (terms * i / threads);
            if (i == threads - 1)
                termParts = termParts + remaining;
/*
            futures[i] = executorService.submit(new Callable<BigDecimal>() {
                @Override
                public BigDecimal call() throws Exception {
                    return getPiBigDecimal(startTerm, termParts);
                }
            });
*/
            futures[i] = executorService.submit(() -> getPiBigDecimal(startTerm, termParts));
        }
        executorService.shutdown();
        System.out.println("Done with thread submission");
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with all the threads " + executorService.isTerminated());
        BigDecimal piValue = BigDecimal.ZERO;
        try {
            for (Future<BigDecimal> f : futures)
                piValue = piValue.add(f.get());
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return piValue;
    }


    // Hint for task 2

    public void doSomething() {
        List<String> stringList = new ArrayList<>();
        stringList.add(new String("test"));
        stringList.add(new String("resting"));
        stringList.add(new String("best"));
        resultSum = 0;
        stringList
                .stream()
                .parallel()
                .map(s -> s.length())
                .forEach(integer -> {
                    resultSum = resultSum + integer;
                });
        System.out.println(resultSum);
    }

}
