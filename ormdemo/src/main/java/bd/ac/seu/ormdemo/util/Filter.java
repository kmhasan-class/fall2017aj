package bd.ac.seu.ormdemo.util;

import bd.ac.seu.ormdemo.model.Course;
import bd.ac.seu.ormdemo.model.Sex;
import bd.ac.seu.ormdemo.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Filter<T> {
    public Collection<T> getSubset(Collection<T> list, TestInterface<T> testInterface) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (testInterface.test(t))
                newList.add(t);
        }
        return newList;
    }
    /*
    public static List<Student> getSubset(List<Student> studentList, TestInterface testInterface) {
        List<Student> newStudentList = new ArrayList<>();
        for (Student student : studentList) {
            if (testInterface.test(student))
                newStudentList.add(student);
        }
        return newStudentList;
    }
    */
    /*
    public static List<Student> getSubset(List<Student> studentList, Sex sex) {
        List<Student> newStudentList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getSex() == sex)
                newStudentList.add(student);
        }
        return newStudentList;
    }

    public static List<Student> getSubsetAddressIsNull(List<Student> studentList) {
        List<Student> newStudentList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getAddress() == null)
                newStudentList.add(student);
        }
        return newStudentList;
    }
*/
    /*
    public static List<Course> getSubset(List<Course> courseList, double credits) {
        List<Course> newCourseList = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getCreditHours() == credits)
                newCourseList.add(course);
        }
        return newCourseList;
    }

    public static List<Course> getSubsetForPrefix(List<Course> courseList, String prefix) {
        List<Course> newCourseList = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getCourseTitle().startsWith(prefix))
                newCourseList.add(course);
        }
        return newCourseList;
    }
    */
}
