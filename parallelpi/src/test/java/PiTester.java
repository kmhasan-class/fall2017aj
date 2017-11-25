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
        int cores = Runtime.getRuntime().availableProcessors();
        String correctValue = "3.141592653589793238462643383279502884197";
        PiCalculator piCalculator = new PiCalculator();
        BigDecimal result = piCalculator.getPiParallel(80000000l, 80);
        String calculatedValue = result.toPlainString().substring(0, 41);
        System.out.printf("Correct    [%s]\n", correctValue);
        System.out.printf("Calculated [%s]\n", calculatedValue);
    }
}
