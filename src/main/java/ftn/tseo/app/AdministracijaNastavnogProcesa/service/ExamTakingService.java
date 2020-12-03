package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.ExamTakingRepository;

@Service
public class ExamTakingService {
	
	@Autowired
	ExamTakingRepository examTakingRepository;
	
	public ExamTaking findOne(Integer id) {
		return examTakingRepository.findById(id).orElse(null);
	}

	public List<ExamTaking> findAll() {
		return examTakingRepository.findAll();
	}
	
	public Page<ExamTaking> findAll(Pageable pageable) {
		return examTakingRepository.findAll(pageable);
	}

	public ExamTaking save(ExamTaking examTaking) {
		return examTakingRepository.save(examTaking);
	}

	public void remove(Integer id) {
		examTakingRepository.deleteById(id);
	}


}
