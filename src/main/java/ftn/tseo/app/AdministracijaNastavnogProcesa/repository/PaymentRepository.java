package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Set<Payment> findAllByStudentId(Integer id);
}
