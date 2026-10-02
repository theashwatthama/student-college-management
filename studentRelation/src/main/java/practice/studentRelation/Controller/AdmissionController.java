package practice.studentRelation.Controller;

import org.springframework.http.HttpStatus;
import practice.studentRelation.Entity.AdmissionRecord;
import practice.studentRelation.Entity.Student;
import practice.studentRelation.Repo.AdmissionRecordRepo;
import practice.studentRelation.Repo.StudentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

    private final AdmissionRecordRepo admissionRecordRepo;
    private final StudentRepo studentRepo;


    private AdmissionController(AdmissionRecordRepo admissionRecordRepo,
                                StudentRepo studentRepo){
        this.admissionRecordRepo=admissionRecordRepo;

        this.studentRepo = studentRepo;
    }

    @PostMapping("/{studentId}")
    private ResponseEntity<AdmissionRecord> createAdmissionRecord(@PathVariable Long studentId,@RequestBody AdmissionRecord admissionRecord){
        Student student = studentRepo.findById(studentId).orElseThrow();
        admissionRecord.setStudent(student);
        AdmissionRecord savedRecord=admissionRecordRepo.save(admissionRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }

    @GetMapping("/{AdmissionRecord_id}")
    private Optional<AdmissionRecord> getAdmissionRecordById(@PathVariable(name = "AdmissionRecord_id") Long id){
        return admissionRecordRepo.findById(id);
    }

    @GetMapping
    private List<AdmissionRecord> getAllAdmissionRecords(){
        return admissionRecordRepo.findAll();
    }

    @PostMapping("/{admissionId}/student/{student}")
    private ResponseEntity<AdmissionRecord> assignStudent(@PathVariable Long admissionId,@PathVariable Long studentId){
        Student student=studentRepo.findById(studentId).orElseThrow();
        AdmissionRecord admissionRecord=admissionRecordRepo.findById(admissionId).orElseThrow();

        admissionRecord.setStudent(student);
        AdmissionRecord savedRecord=admissionRecordRepo.save(admissionRecord);
        return ResponseEntity.ok(savedRecord);
    }
}
