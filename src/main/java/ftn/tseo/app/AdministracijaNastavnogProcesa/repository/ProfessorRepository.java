package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
