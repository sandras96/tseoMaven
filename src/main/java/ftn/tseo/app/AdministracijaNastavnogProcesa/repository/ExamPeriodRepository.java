package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Integer> {

	ExamPeriod findByName(String name);
	
	List<ExamPeriod> findAllByNameContaining(String name);
}
