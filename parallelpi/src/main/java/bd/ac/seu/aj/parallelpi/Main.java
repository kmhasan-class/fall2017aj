package bd.ac.seu.aj.parallelpi;

// Correct value of PI
// 3.141592653589793238462643383279502884197
public class Main {
    public Main() {
        PiCalculator piCalculator = new PiCalculator();
        System.out.println(piCalculator.getPi(1l));
        System.out.println(piCalculator.getPi(10l));
        System.out.println(piCalculator.getPi(100l));
        System.out.println(piCalculator.getPi(1000l));
        System.out.println(piCalculator.getPi(10000l));
        System.out.println(piCalculator.getPi(100000l));
        System.out.println(piCalculator.getPi(1000000l));
        System.out.println(piCalculator.getPi(10000000l));
        System.out.println(piCalculator.getPi(100000000l));
        System.out.println(piCalculator.getPi(1000000000l));
        System.out.println(piCalculator.getPi(10000000000l));
    }

    public static void main(String args[]) {
        new Main();
    }
}
