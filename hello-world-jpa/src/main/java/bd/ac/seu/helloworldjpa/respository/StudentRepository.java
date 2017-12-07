package bd.ac.seu.helloworldjpa.respository;

import bd.ac.seu.helloworldjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    public Student findByStudentName(String name);
    public List<Student> findAllByCgpaGreaterThanEqual(double gpa);
}
