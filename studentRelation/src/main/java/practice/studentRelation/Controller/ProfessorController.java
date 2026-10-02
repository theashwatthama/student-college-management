package practice.studentRelation.Controller;

import practice.studentRelation.Entity.Professor;
import practice.studentRelation.Entity.Student;
import practice.studentRelation.Repo.ProfessorRepo;
import practice.studentRelation.Repo.StudentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorRepo professorRepo;
    private final StudentRepo studentRepo;
    private ProfessorController(ProfessorRepo professorRepo,StudentRepo studentRepo){
        this.professorRepo=professorRepo;
        this.studentRepo=studentRepo;
    }

    @PostMapping
    private Professor createProfessor(@RequestBody Professor professor){
        return professorRepo.save(professor);
    }

    @GetMapping("/{professor_id}")
    private Optional<Professor> getProfessorById(@PathVariable(name = "professor_id") Long id){
        return professorRepo.findById(id);
    }

    @GetMapping
    private List<Professor> getAllProfessors(){
        return professorRepo.findAll();
    }

    @PostMapping("/{professorId}/student/{studentId}")
    private ResponseEntity<Professor> assignStudent(
            @PathVariable Long professorId,
            @PathVariable Long studentId) {

        Professor professor =professorRepo.findById(professorId).orElseThrow();
        Student student=studentRepo.findById(studentId).orElseThrow();

        professor.getStudents().add(student);
        Professor savedProfessor=professorRepo.save(professor);
        return ResponseEntity.ok(savedProfessor);
    }



}
