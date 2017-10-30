package bd.ac.seu.ormdemo.util;

import bd.ac.seu.ormdemo.model.Student;

@FunctionalInterface // Can have exactly one abstract method
public interface TestInterface<T> {
    public boolean test(T t);
    //public boolean rest(Student student);
    public default void whatever() {
        System.out.println("Whatever!");
    }
}
