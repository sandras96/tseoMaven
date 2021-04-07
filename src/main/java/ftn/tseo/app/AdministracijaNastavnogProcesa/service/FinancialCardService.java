package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FinancialCard;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.FinancialCardRepository;

@Service
public class FinancialCardService {
	
	
	@Autowired 
	FinancialCardRepository financialCardrepository;
	
	public FinancialCard save(FinancialCard financialCard) {
		return financialCardrepository.save(financialCard);
	}
	
	public FinancialCard findByStudent(Integer id) {
		return financialCardrepository.findByStudentId(id);
	}
}
