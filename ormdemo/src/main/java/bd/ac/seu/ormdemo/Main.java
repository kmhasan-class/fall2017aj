package bd.ac.seu.ormdemo;

import bd.ac.seu.ormdemo.model.Course;
import bd.ac.seu.ormdemo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public Main() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Student student = session.get(Student.class, 53);
        System.out.println(student);
        for (Course course : student.getCourseSet())
            System.out.println(course);
        /*
        Course course1 = session.get(Course.class, "CSE2015");
        Course course2 = session.get(Course.class, "CSE2016");
        student.getCourseSet().add(course1);
        student.getCourseSet().add(course2);
        */
        session.save(student);

/*
        Query query = session.createQuery("from Student"); // HQL - Hibernate Query Language
        List<Student> studentList = query.getResultList();
        studentList.forEach(System.out::println);

        query = session.createQuery("from Course");
        List<Course> courseList = query.getResultList();
        courseList.forEach(System.out::println);
        */
/*
        session.save(new Course("CSE4047", "Advanced Java", 3.0));
        session.save(new Course("CSE4048", "Advanced Java Lab", 1.0));
        session.save(new Course("CSE4029", "Image Processing", 3.0));
        session.save(new Course("CSE2015", "Programming Language II (Java)", 3.0));
        session.save(new Course("CSE2016", "Programming Language II (Java) Lab", 1.0));
*/
        session.getTransaction().commit();

        //System.out.println(student);
    }

    public static void main(String args[]) {
        new Main();
    }
}
