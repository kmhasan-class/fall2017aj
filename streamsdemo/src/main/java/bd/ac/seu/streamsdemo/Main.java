package bd.ac.seu.streamsdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private List<Student> studentList;

    public Main() {
        studentList = new ArrayList<>();
        studentList.add(new Student(5, "Babul", 20));
        studentList.add(new Student(15, "Abul", 21));
        studentList.add(new Student(32, "Kabul", 22));
        studentList.add(new Student(14, "Putul", 19.2));
        studentList.add(new Student(11, "Ratul", 25));
        studentList.add(new Student(12, "Tutul", 26));
        studentList.add(new Student(16, "Tetul", 22));
        studentList.add(new Student(8, "Rakibul", 21));
        studentList.add(new Student(7, "Monirul", 23));

        studentList.stream().filter(student -> student.getAge() >= 22).forEach(System.out::println);
/*

        double sum = 0;
        for (Student student : studentList)
            sum = sum + student.getAge();
        double averageAge = sum / studentList.size();

*/
        double averageAge = studentList.stream().filter(student -> student.getAge() >= 22).mapToDouble(Student::getAge).average().getAsDouble();

        int nameLengthSum = studentList
                .stream()
                .mapToInt(student -> student.getName().length())
                .sum();
        double averageNameLength = nameLengthSum / studentList.size();

        List<Student> oldStudentsWhoseNameStartWithT = studentList.stream().filter(student -> student.getAge() >= 22).filter(student->student.getName().startsWith("T")).collect(Collectors.toList());

        System.out.println("Average age = " + averageAge);
        System.out.println("Average name length = " + averageNameLength);
        System.out.println(oldStudentsWhoseNameStartWithT);
    }

    public static void main(String args[]) {
        new Main();
    }
}
