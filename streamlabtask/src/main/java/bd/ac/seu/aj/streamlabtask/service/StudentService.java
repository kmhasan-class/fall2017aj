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

    /**
     * Computes the CGPA of a student
     * @param studentId the id of the student
     * @return CGPA of the student
     */
    public double getCgpa(int studentId) {
        // ADD CODE TO DO THE COMPUTATIONS WITH LAMBDAS AND STREAMS
        //findAll().stream().filter(student -> student.getStudentId() == studentId).findFirst().get().
        return 0.0;
    }

    /**
     * Computes the term GPA of a student for a given semester
     * @param studentId the id of the student
     * @param semesterNumber the semester number
     * @return term GPA of the student for the given semester
     */
    public double getGpa(int studentId, int semesterNumber) {
        // ADD CODE TO DO THE COMPUTATIONS WITH LAMBDAS AND STREAMS
        return 0.0;
    }

    /**
     * Computes the average GPA of all the students for a given semester
     * @param semesterNumber the semester number
     * @return average GPA of all the students for the given semester
     */
    public double getAverageGpa(int semesterNumber) {
        // ADD CODE TO DO THE COMPUTATIONS WITH LAMBDAS AND STREAMS
        return 0.0;
    }

    /**
     * Finds the student with the highest CGPA
     * @return optionally returns student object that has the highest CGPA if one such exists
     */
    public Optional<Student> getBestStudent() {
        // ADD CODE TO DO THE COMPUTATIONS WITH LAMBDAS AND STREAMS
        //Student bestStudent = null;
        //Optional<Student> optionalStudent = Optional.of(bestStudent);
        return null;
    }
}
