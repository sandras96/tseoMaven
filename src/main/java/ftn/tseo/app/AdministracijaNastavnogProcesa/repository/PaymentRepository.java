package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	//@Query(value = "SELECT p.* FROM payment p JOIN financialcard fc ON p.financial_card_id = fc.financial_card_id WHERE fc.student_id = ?;",nativeQuery = true)
	//Set<Payment> findAllByStudent(Integer id);
	Set<Payment> findAllByFinancialCardId(Integer id);
}
