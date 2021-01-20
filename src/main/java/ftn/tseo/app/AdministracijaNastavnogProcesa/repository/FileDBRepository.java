package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FileDB;


public interface FileDBRepository extends JpaRepository<FileDB, Integer>{

	Set<FileDB> findAllByStudentId(Integer id);
	
}
