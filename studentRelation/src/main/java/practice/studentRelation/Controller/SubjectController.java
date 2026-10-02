package practice.studentRelation.Controller;

import practice.studentRelation.Entity.Professor;
import practice.studentRelation.Entity.Subject;
import practice.studentRelation.Repo.ProfessorRepo;
import practice.studentRelation.Repo.SubjectRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private SubjectRepo subjectRepo;
    private ProfessorRepo professorRepo;
    private SubjectController(SubjectRepo subjectRepo,ProfessorRepo professorRepo){
        this.subjectRepo=subjectRepo;
        this.professorRepo=professorRepo;
    }

    @PostMapping
    private Subject createSubject(@RequestBody Subject subject){
        return subjectRepo.save(subject);
    }

    @GetMapping("/{subject_id}")
    private Optional<Subject> getSubjectById(@PathVariable(name = "subject_id") Long id){
        return subjectRepo.findById(id);
    }

    @GetMapping
    private List<Subject> getAllSubjects(){
        return subjectRepo.findAll();
    }

    @PostMapping("/{subjectId}/professor/{professorId}")
    private ResponseEntity<Subject> assignProfessor( @PathVariable Long subjectId, @PathVariable Long professorId){
        Subject subject=subjectRepo.findById(subjectId).orElseThrow();
        Professor professor=professorRepo.findById(professorId).orElseThrow();

        subject.setProfessor(professor);
        Subject savedProfessor=subjectRepo.save(subject);
        return ResponseEntity.ok(savedProfessor);
    }
}
