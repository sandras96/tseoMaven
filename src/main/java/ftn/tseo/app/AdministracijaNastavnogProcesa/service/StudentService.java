package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentDTOtoStudent;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.StudentRepository;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.UserRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;;

	@Autowired
	UserRepository userRepository;

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

	public Student findByIndexNum(String indexNum) {
		return studentRepository.findByIndexNum(indexNum);
	}
	public Student findByUserId(Integer id) {
		return studentRepository.findByUserId(id);
	}
	public List<Student> findByFirstname(String firstname) {
		return studentRepository.findByFirstnameContaining(firstname);
	}
	public List<Student> findByLastname(String lastname) {
		return studentRepository.findByLastnameContaining(lastname);
	}
	public List<Student> findByIndexnumber(String indexNum) {
		return studentRepository.findByIndexNumContaining(indexNum);
	}
}
