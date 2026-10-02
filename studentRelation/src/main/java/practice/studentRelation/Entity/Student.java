package practice.studentRelation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;


    @ManyToMany(mappedBy = "students")
    private List<Professor> professors = new ArrayList<>();


    @ManyToMany
    private List<Subject> subjects=new ArrayList<>();

    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;
}
