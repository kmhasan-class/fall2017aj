package bd.ac.seu.aj.parallelpi;

import java.util.Comparator;
import java.util.List;

/*
 5 4 2 3 1 6 8 7 9 2 10 5
 4 2 3 1 5 6 7 8 2 9 5 10
 */

public class Sorter<T> {
    public void sort(List<T> itemList, Comparator<T> comparator) {
        for (int i = 0; i < itemList.size() - 1; i++) {
            for (int j = 0; j < itemList.size() - i - 1; j++) {
                T t1 = itemList.get(j);
                T t2 = itemList.get(j + 1);
                if (comparator.compare(t1, t2) > 0) {
                    itemList.set(j, t2);
                    itemList.set(j + 1, t1);
                }
            }
        }
    }

    public void parallelSort(List<T> itemList, Comparator<T> comparator) {
        // HOMETASK: implement this method by using the sort method

        // HINT: you need to modify the sort method so that it works for a certain
        // range of a list
    }
}
