package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService {
	
	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	public ExamPeriod findOne(Integer id) {
		return examPeriodRepository.findById(id).orElse(null);
	}

	public List<ExamPeriod> findAll() {
		return examPeriodRepository.findAll();
	}
	
	public Page<ExamPeriod> findAll(Pageable pageable) {
		return examPeriodRepository.findAll(pageable);
	}

	public ExamPeriod save(ExamPeriod examPeriod) {
		return examPeriodRepository.save(examPeriod);
	}

	public void remove(Integer id) {
		examPeriodRepository.deleteById(id);
	}


}
