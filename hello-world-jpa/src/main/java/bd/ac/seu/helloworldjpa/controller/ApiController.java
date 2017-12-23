package bd.ac.seu.helloworldjpa.controller;

import bd.ac.seu.helloworldjpa.model.Student;
import bd.ac.seu.helloworldjpa.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("students")
    public List<Student> findAllStudents(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        authentication.getAuthorities().forEach(System.out::println);
        return studentRepository.findAll();
    }

    @RequestMapping("student/{id}")
    public Student findOne(@PathVariable String id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(value = "student", method = RequestMethod.POST)
    public Student addStudent(@RequestParam String studentId,
                              @RequestParam String studentName,
                              @RequestParam double cgpa) {
        System.out.println("addStudent got called");
        System.out.println("studentId = " + studentId);
        System.out.println("studentName = " + studentName);
        System.out.println("cgpa = " + cgpa);
        Student student = new Student(studentId, studentName, cgpa);
        student = studentRepository.save(student);

        return student;
    }
}
