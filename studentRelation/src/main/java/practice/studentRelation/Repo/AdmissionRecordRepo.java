package practice.studentRelation.Repo;

import practice.studentRelation.Entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecord, Long> {
}