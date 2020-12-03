package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Assignment;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.AssignmentRepository;

@Service
public class AssignmentService {
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	public Assignment findOne(Integer id) {
		return assignmentRepository.findById(id).orElse(null);
	}

	public List<Assignment> findAll() {
		return assignmentRepository.findAll();
	}
	
	public Page<Assignment> findAll(Pageable pageable) {
		return assignmentRepository.findAll(pageable);
	}

	public Assignment save(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

	public void remove(Integer id) {
		assignmentRepository.deleteById(id);
	}

	
	

}
