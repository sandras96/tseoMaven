package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public Student findOne(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Page<Student> findAll(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void remove(Integer id) {
		studentRepository.deleteById(id);
	}

}
