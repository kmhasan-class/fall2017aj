package bd.ac.seu.ormdemo;

import bd.ac.seu.ormdemo.Service.StudentService;
import bd.ac.seu.ormdemo.model.Sex;
import bd.ac.seu.ormdemo.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public Main() {
        StudentService studentService = new StudentService();
        List<Student> studentList = studentService.getStudentList();

        long startTime, stopTime;

        startTime = System.currentTimeMillis();
        List<Student> femaleStudents = new ArrayList<>();
        for (Student student : studentList)
            if (student.getSex() == Sex.FEMALE)
                femaleStudents.add(student);
        stopTime = System.currentTimeMillis();
        System.out.println("We got " + femaleStudents.size() + " female students");
        System.out.printf("Time taken: %.6f seconds\n", (stopTime - startTime) / 1000.0);

        startTime = System.currentTimeMillis();
        List<Student> maleStudents = studentList
                .parallelStream()
                .filter(student -> student.getSex() == Sex.MALE)
                .collect(Collectors.toList());
        stopTime = System.currentTimeMillis();
        System.out.println("We got " + maleStudents.size() + " male students");
        System.out.printf("Time taken: %.6f seconds\n", (stopTime - startTime) / 1000.0);

        //studentList.forEach(System.out::println);
        /*
            public Student(int id, Name name, String emailAddress, Sex sex, Address address) {
        this();
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.sex = sex;
        this.address = address;
    }

         */
        /*
        for (int i = 1; i <= 1000000; i++) {
            Student student = new Student(i,
                    null,
                    null,
                    Math.random() < 0.5 ? Sex.MALE : Sex.FEMALE,
                    null);
            studentService.addStudent(student);
        }
*/
        /*
        Course course1 = session.get(Course.class, "CSE2015");
        Course course2 = session.get(Course.class, "CSE2016");
        student.getCourseSet().add(course1);
        student.getCourseSet().add(course2);
        */
/*
        Course course = session.get(Course.class, "CSE4029");
        System.out.println(course);
        System.out.println("Registered students:");
        course.getStudentList().forEach(System.out::println);
*/

/*
        Query query = session.createQuery("from Student"); // HQL - Hibernate Query Language
        List<Student> studentList = query.getResultList();
        studentList.forEach(System.out::println);

        query = session.createQuery("from Course");
        List<Course> courseList = query.getResultList();
        courseList.forEach(System.out::println);
        */
/*
        session.save(new Course("CSE4047", "Advanced Java", 3.0));
        session.save(new Course("CSE4048", "Advanced Java Lab", 1.0));
        session.save(new Course("CSE4029", "Image Processing", 3.0));
        session.save(new Course("CSE2015", "Programming Language II (Java)", 3.0));
        session.save(new Course("CSE2016", "Programming Language II (Java) Lab", 1.0));
*/


        //System.out.println(student);
    }

    public static void main(String args[]) {
        new Main();
    }
}
