package bd.ac.seu.ormdemo.Service;

import bd.ac.seu.ormdemo.SessionFactorySingleton;
import bd.ac.seu.ormdemo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class StudentService {
    SessionFactory sessionFactory;

    public StudentService() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }


    // Create
    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(student);
        session.getTransaction().commit();
    }

    // Create
    public void addAll(List<Student> studentList) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        //studentList.forEach(student -> session.save(student));
        for (Student student : studentList)
            session.save(student);
        session.getTransaction().commit();
    }

    // Read
    public List<Student> getStudentList() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        return query.getResultList();
    }

    // Read
    public Student getStudent(int studentId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Student student = session.get(Student.class, studentId);
        session.getTransaction().commit();
        return student;
    }

    // Update
    public void updateStudent(Student student) {

    }

    // Delete
    public void deleteStudent(int studentId) {

    }
}
