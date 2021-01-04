package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{
	
	List<Exam> findAllByCourseId(Integer id);

}
