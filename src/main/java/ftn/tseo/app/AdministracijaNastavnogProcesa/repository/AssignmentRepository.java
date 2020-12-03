package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}
