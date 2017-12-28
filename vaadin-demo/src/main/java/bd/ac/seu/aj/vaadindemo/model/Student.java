package bd.ac.seu.aj.vaadindemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private double cgpa;
}
