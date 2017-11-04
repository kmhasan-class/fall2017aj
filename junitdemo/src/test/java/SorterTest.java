import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorterTest {
    @Test
    public void testSort() {
        String strings[] = {"Cranberry", "Apple", "Banana", "Jackfruit"};

        List<String> list = Arrays.asList(strings);
        List<String> anotherList = new ArrayList<String>();
        for (int i = 0; i < strings.length; i++)
            anotherList.add(strings[i]);

        Sorter<String> stringSorter = new Sorter<String>();
        stringSorter.sort(list);

        Collections.sort(anotherList);

        assertEquals(anotherList, list);
    }

    /*
    HOMEWORK: Test the bubble sort algorithm on 10 million random
    integers. See if it passes within 10 milliseconds.
    Hint: There's an annotation for timeout in tests.
    */
}
