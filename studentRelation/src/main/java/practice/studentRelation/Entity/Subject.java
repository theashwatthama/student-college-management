package practice.studentRelation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String subjectName;


    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "professor_id",nullable = true)
    private Professor professor;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students=new ArrayList<>();
}
