package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	Student findByIndexNum(String indexNum);
	Student findByUserId(Integer id);

	
}
