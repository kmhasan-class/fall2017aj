import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Point p = new Point(2, 2);
        Point q = new Point(6, 4);
        int distance = p.getDistance(q);
        System.out.printf("Distance from %s to %s = %d\n", p, q, distance);

        Sorter<String> stringSorter = new Sorter<String>();
        String strings[] = {"Babul", "Abul", "Kabul"};
        List<String> stringList = Arrays.asList(strings);
        System.out.println("Before sorting: " + stringList);
        stringSorter.sort(stringList);
        System.out.println("After sorting: " + stringList);
    }
}
