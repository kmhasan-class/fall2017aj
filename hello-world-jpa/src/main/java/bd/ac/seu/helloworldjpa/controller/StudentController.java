package bd.ac.seu.helloworldjpa.controller;

import bd.ac.seu.helloworldjpa.model.Student;
import bd.ac.seu.helloworldjpa.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

/*    @RequestMapping(value = "/")
    @ResponseBody
    public String handleIndex() {
        return "HELLO!";
    }*/

    @RequestMapping(value="/greetings")
    public String handleGreetings(Model model) {
        model.addAttribute("name", "Somename");
        return "greetings";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String handleIndexWithName(@RequestParam String name) {
        return "HELLO, " + name + "!";
    }

    @RequestMapping(value = "/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @RequestMapping(value = "/student/{id}")
    public String getOneStudent(@PathVariable String id, Model model) {
        model.addAttribute("student", studentRepository.findOne(id));
        return "student";
    }

    @RequestMapping(value = "/insert_student", method = RequestMethod.POST)
    @ResponseBody
    public String insertStudent(@RequestParam String id,
                                @RequestParam String name,
                                @RequestParam double cgpa) {
        Student student = new Student(id, name, cgpa);
        studentRepository.save(student);
        return "Student inserted";
    }

    @RequestMapping(value = "/students_model")
    //@ResponseBody
    public void getAllStudentsInModel(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        ///return studentRepository.findAll();
    }
}
