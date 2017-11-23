import bd.ac.seu.aj.parallelpi.PiCalculator;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PiTester {
    /*
    @Test
    public void testPi() {
        // Correct value of PI
        String correctValue = "3.141592653589793238462643383279502884197";
        PiCalculator piCalculator = new PiCalculator();
        String calculatedValue = String.format("%.39f", piCalculator.getPi(80000000l));
        System.out.printf("Correct    [%s]\n", correctValue);
        System.out.printf("Calculated [%s]\n", calculatedValue);
    }
    */
/*
    @Test
    @Ignore
    public void testPiBigDecimal() {
        // Correct value of PI
        String correctValue = "3.141592653589793238462643383279502884197";
        PiCalculator piCalculator = new PiCalculator();
        String calculatedValue = piCalculator.getPiBigDecimal(80000000l).toPlainString().substring(0, 41);
        System.out.printf("Correct    [%s]\n", correctValue);
        System.out.printf("Calculated [%s]\n", calculatedValue);
    }
*/
    @Test
    public void testMultiThread() {
        PiCalculator piCalculator = new PiCalculator();
        Thread thread1 = new Thread(() -> {
                BigDecimal result1 = piCalculator.getPiBigDecimal(1, 40000000l);
            }
        );
        thread1.start();
        Thread thread2 = new Thread(() -> {
                BigDecimal result2 = piCalculator.getPiBigDecimal(40000001, 40000000l);
            }
        );
        thread2.start();
        //BigDecimal result = result1.add(result2);
        //System.out.println(result);

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
