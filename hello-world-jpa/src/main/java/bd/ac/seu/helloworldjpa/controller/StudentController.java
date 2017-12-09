package bd.ac.seu.helloworldjpa.controller;

import bd.ac.seu.helloworldjpa.model.Student;
import bd.ac.seu.helloworldjpa.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/")
    @ResponseBody
    public String handleIndex() {
        return "HELLO!";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String handleIndexWithName(@RequestParam String name) {
        return "HELLO, " + name + "!";
    }

    @RequestMapping(value = "/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/student")
    @ResponseBody
    public Student getOneStudent(@RequestParam String id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(value = "/insert_student")
    @ResponseBody
    public String insertStudent(@RequestParam String id,
                                @RequestParam String name,
                                @RequestParam double cgpa) {
        studentRepository.save(new Student(id, name, cgpa));
        return "Student inserted";
    }
}
