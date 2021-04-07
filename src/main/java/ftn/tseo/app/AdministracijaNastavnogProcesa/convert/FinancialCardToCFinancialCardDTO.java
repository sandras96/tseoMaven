package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.FinancialCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FinancialCard;

@Component
public class FinancialCardToCFinancialCardDTO implements Converter<FinancialCard, FinancialCardDTO>{

	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@Override
	public FinancialCardDTO convert(FinancialCard source) {
		if(source == null) {
			return null;
		}
		FinancialCardDTO financialCardDTO = new FinancialCardDTO();
		financialCardDTO.setId(source.getId());
		
		if(source.getAccountNumber()!=null) {
			financialCardDTO.setAccountNumber(source.getAccountNumber());
		}
		if(source.getModel()!=null) {
			financialCardDTO.setModel(source.getModel());
		}
		if(source.getReference()!=null) {
			financialCardDTO.setReference(source.getReference());
		}
		if(source.getBalance()!=0) {
			financialCardDTO.setBalance(source.getBalance());
		}
		if(source.getStudent()!=null) {
			financialCardDTO.setStudent(studentToStudentDTO.convert(source.getStudent()));
		}
		return financialCardDTO;
	}

	
	
}
