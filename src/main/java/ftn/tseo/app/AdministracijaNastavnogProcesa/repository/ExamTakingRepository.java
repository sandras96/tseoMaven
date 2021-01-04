package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;

public interface ExamTakingRepository extends JpaRepository<ExamTaking, Integer> {
	
	List<ExamTaking> findAllByProfessorId(Integer id);

}
