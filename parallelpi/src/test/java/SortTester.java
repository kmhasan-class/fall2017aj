import bd.ac.seu.aj.parallelpi.Sorter;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTester {
    @Test
    public void testSort() {
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 34, 5, 3, 2, 4, 3, 2, 45, 1, 4));
//        List<Integer> sortedList  = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 34, 45));
        List<Integer> integerList = new ArrayList<>();
        List<Integer> sortedList  = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int randomNumber = (int) (Math.random() * 10000);
            integerList.add(randomNumber);
            sortedList.add(randomNumber);
        }

        System.out.println("Generated data");
        Sorter<Integer> sorter = new Sorter<>();
        //System.out.println("Before sorting: " + integerList);
        sorter.sort(integerList, (i1, i2) -> i1 - i2);
        //System.out.println("After sorting:  " + integerList);
        System.out.println("done with bubble sort");

        Collections.sort(sortedList);
        System.out.println("done with Java's sort");

        assertEquals(sortedList, integerList);
    }
}
