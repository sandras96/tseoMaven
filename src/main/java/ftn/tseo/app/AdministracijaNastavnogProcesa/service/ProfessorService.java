package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	
	@Autowired
	ProfessorRepository professorRepository;
	
	public Professor findOne(Integer id) {
		return professorRepository.findById(id).orElse(null);
	}

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}
	
	public Page<Professor> findAll(Pageable pageable) {
		return professorRepository.findAll(pageable);
	}

	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}

	public void remove(Integer id) {
		professorRepository.deleteById(id);
	}
	
	public List<Professor> getAllByCourseId(Integer id) {
		return professorRepository.getAllByCourseId(id);
	}
	public Professor findByUserId(Integer id) {
		return professorRepository.findByUserId(id);
	}
	public List<Professor> findAllByFirstname(String firstname) {
		return professorRepository.findAllByFirstnameContaining(firstname);
	}
	public List<Professor> findAllByLastname(String lastname) {
		return professorRepository.findAllByLastnameContaining(lastname);
	}
	public List<Professor> findAllByRole(String role) {
		return professorRepository.findAllByRole(role);
	}
	
}
