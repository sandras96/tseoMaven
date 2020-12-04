package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;

public class StudentToStudentDTO implements Converter<Student, StudentDTO> {

	@Autowired
	UserToUserDTO userToUserDTO;
	
	@Override
	public StudentDTO convert(Student source) {
		if(source == null) {
			return null;
		}
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(source.getId());
		if(source.getAddress()!=null) {
			studentDTO.setAddress(source.getAddress());
		}
		if(source.getCity()!=null) {
			studentDTO.setCity(source.getCity());
		}
		if(source.getCountry()!=null) {
			studentDTO.setCountry(source.getCountry());
		}
		if(source.getZip()!=null) {
			studentDTO.setZip(source.getZip());
		}
		if(source.getBirthdate()!=null) {
			studentDTO.setBirthDate(source.getBirthdate());
		}
		if(source.getIndexNum()!=null) {
			studentDTO.setIndexNum(source.getIndexNum());
		}
		if(source.getUser()!=null) {
			studentDTO.setUser(userToUserDTO.convert(source.getUser()));
		}
		
		return studentDTO;
	}

}
