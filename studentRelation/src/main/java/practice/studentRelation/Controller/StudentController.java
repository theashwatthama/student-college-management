package practice.studentRelation.Controller;

import practice.studentRelation.Entity.Student;
import practice.studentRelation.Entity.Subject;
import practice.studentRelation.Repo.StudentRepo;
import practice.studentRelation.Repo.SubjectRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepo studentRepo;
    private SubjectRepo subjectRepo;
    private StudentController(StudentRepo studentRepo,SubjectRepo subjectRepo){
        this.studentRepo=studentRepo;
        this.subjectRepo=subjectRepo;
    }

    @PostMapping
    private Student createStudent(@RequestBody Student Student){
        return studentRepo.save(Student);
    }

    @GetMapping("/{student_id}")
    private Optional<Student> getStudentById(@PathVariable(name = "student_id") Long id){
        return studentRepo.findById(id);
    }

    @GetMapping
    private List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @PostMapping("/{studentId}/subject/{subjectId}")
    private ResponseEntity<Student> assignSubjects(
            @PathVariable Long studentId,
            @PathVariable Long subjectId){

        Student student=studentRepo.findById(studentId).orElseThrow();
        Subject subject=subjectRepo.findById(subjectId).orElseThrow();

        student.getSubjects().add(subject);

        Student savedSubjects=studentRepo.save(student);
        return ResponseEntity.ok(savedSubjects);
    }



}
