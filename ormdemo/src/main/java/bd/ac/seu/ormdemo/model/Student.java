package bd.ac.seu.ormdemo.model;

// JPA - Java Persistence API

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    private int id;
    @Embedded
    private Name name;
    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Embedded
    private Address address;
    @ManyToMany
    @JoinTable(name = "Registration",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "courseCode")})
    private Set<Course> courseSet;

    public Student() {
        courseSet = new HashSet<>();
    }

    public Student(int id, Name name, String emailAddress, Sex sex, Address address) {
        this();
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Sex getSex() {
        return sex;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", emailAddress='" + emailAddress + '\'' +
                ", sex=" + sex +
                ", address=" + address +
                ", courseSet=" + courseSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
