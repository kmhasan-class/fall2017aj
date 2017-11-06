package bd.ac.seu.aj.streamlabtask.service;

import bd.ac.seu.aj.streamlabtask.model.Sex;
import bd.ac.seu.aj.streamlabtask.model.Student;
import bd.ac.seu.aj.streamlabtask.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentService {
    public List<Student> findAll() {
        return StudentRepository.getStudentList();
    }

    public List<Student> findStudentsBySex(Sex sex) {
        return findAll().stream().filter(student -> student.getSex() == sex).collect(Collectors.toList());
    }

    public Optional<Student> findStudentById(int studentId) {
        return findAll().stream().filter(student -> student.getStudentId() == studentId).findAny();
    }
}
