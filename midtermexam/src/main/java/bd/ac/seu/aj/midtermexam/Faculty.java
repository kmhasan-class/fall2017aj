package bd.ac.seu.aj.midtermexam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty {
    @Id
    private String facultyInitials;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Rank rank;
    @OneToMany
    private List<Section> sectionList;


    public List<Faculty> readAllFaculties() {
        SessionFactory sessionFactory = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Faculty");
        List<Faculty> facultyList = query.getResultList();
        return facultyList;
    }
}
