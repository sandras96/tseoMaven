package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{
	
	Set<Document> findAllByStudentId(Integer id);

}
