package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FinancialCard;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Integer>{

	FinancialCard findByStudentId(Integer id);
}
