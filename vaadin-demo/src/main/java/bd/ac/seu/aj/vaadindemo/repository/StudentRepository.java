package bd.ac.seu.aj.vaadindemo.repository;

import bd.ac.seu.aj.vaadindemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findStudentsByStudentName(String studentName);
}
