package bd.ac.seu.aj.streamlabtask;

import bd.ac.seu.aj.streamlabtask.model.Sex;
import bd.ac.seu.aj.streamlabtask.service.CourseService;
import bd.ac.seu.aj.streamlabtask.service.StudentService;

public class Main {
    public Main() {
        StudentService studentService = new StudentService();
        System.out.println("Student count "  + studentService.findAll().size());
        System.out.println("Male student count " + studentService.findStudentsBySex(Sex.MALE).size());
        System.out.println("Female student count " + studentService.findStudentsBySex(Sex.FEMALE).size());
        System.out.println("Student with id 0 " + studentService.findStudentById(0));

        CourseService courseService = new CourseService();
        courseService.findByPrefix("CSE").forEach(System.out::println);
    }

    public static void main(String args[]) {
        new Main();
    }
}
