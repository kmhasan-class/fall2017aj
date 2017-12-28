package bd.ac.seu.aj.vaadindemo.service;

import bd.ac.seu.aj.vaadindemo.model.Student;
import bd.ac.seu.aj.vaadindemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(String studentId, String studentName, double cgpa) {
        System.out.printf("Add student called with [%s, %s, %.2f]\n", studentId, studentName, cgpa);
        Student student = new Student(studentId, studentName, cgpa);
        return studentRepository.save(student);
    }
}
