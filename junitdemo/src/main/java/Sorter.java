import java.util.List;

/*
If you're new to Java Generics, you can google "java trail generics"
 */
public class Sorter<T> {
    /*
    HOMEWORK: Implement Bubble sort here
    */
    public void sort(List<T> list) {
        T temp = list.get(0);
        list.set(0, list.get(1));
        list.set(1, temp);
    }
}
