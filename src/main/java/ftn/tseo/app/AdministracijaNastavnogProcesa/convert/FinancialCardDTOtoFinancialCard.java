package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.FinancialCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FinancialCard;

@Component
public class FinancialCardDTOtoFinancialCard implements Converter<FinancialCardDTO, FinancialCard>{

	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;
	
	@Override
	public FinancialCard convert(FinancialCardDTO source) {
		if(source == null) {
			return null;
		}
		FinancialCard fc = new FinancialCard();
		fc.setId(source.getId());
		
		if(source.getAccountNumber()!=null) {
			fc.setAccountNumber(source.getAccountNumber());
		}
		if(source.getModel()!=null) {
			fc.setModel(source.getModel());
		}
		if(source.getBalance()!=0) {
			fc.setBalance(source.getBalance());
		}
		if(source.getReference()!=null) {
			fc.setReference(source.getReference());
		}
		
		if(source.getStudent()!=null) {
			fc.setStudent(studentDTOtoStudent.convert(source.getStudent()));
		}
		
		return fc;
}

}