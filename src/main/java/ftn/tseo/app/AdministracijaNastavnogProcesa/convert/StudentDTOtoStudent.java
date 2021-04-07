package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;

@Component
public class StudentDTOtoStudent implements Converter<StudentDTO, Student>  {
	
	@Autowired
	UserDTOtoUser userDTOtoUser;
	
	@Autowired
	DocumentDTOtoDocument documentDTOtoDocument;
	
	@Autowired
	FinancialCardDTOtoFinancialCard financialCardDTOToCFinancialCard;

	@Override
	public Student convert(StudentDTO source) {
		
		if(source==null) {
			return null;
		}
		Student student = new Student();
		student.setPerson_id(source.getId());
		
		if(source.getFirstname()!=null) {
			student.setFirstname(source.getFirstname());
		}
		if(source.getLastname()!=null) {
			student.setLastname(source.getLastname());
		}
		if(source.getAddress()!=null) {
			student.setAddress(source.getAddress());
		}
		if(source.getCity()!=null) {
			student.setCity(source.getCity());
		}
		if(source.getCountry()!=null) {
			student.setCountry(source.getCountry());
		}
		if(source.getZip()!=null) {
			student.setZip(source.getZip());
		}
		if(source.getBirthDate()!=null) {
			student.setBirthdate(source.getBirthDate());
		}
		if(source.getIndexNum()!=null) {
			student.setIndexNum(source.getIndexNum());
		}
		if(source.getEmail()!=null) {
			student.setEmail(source.getEmail());
		}
		if(source.getPhone()!=null) {
			student.setPhone(source.getPhone());
		}
		if(source.getUser()!=null) {
			student.setUser(userDTOtoUser.convert(source.getUser())); 
		}
//		if(source.getFinancialCard()!=null) {
//			student.setFinancialCard(financialCardDTOToCFinancialCard.convert(source.getFinancialCard()));
//		}
	
//		if(source.getDocuments()!=null) {
//			student.setDocuments(documentDTOtoDocument.convert(source.getDocuments()));
//		}
		return student;
	}

}
