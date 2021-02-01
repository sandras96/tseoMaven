package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;

@Component
public class ProfessorDTOtoProfessor implements Converter<ProfessorDTO, Professor>{

	@Autowired
	UserDTOtoUser userDTOtoUser;
	
	@Override
	public Professor convert(ProfessorDTO source) {
		if(source == null) {
			return null;
		}
		Professor professor = new Professor();
		professor.setPerson_id(source.getId());
		
		if(source.getFirstname()!=null) {
			professor.setFirstname(source.getFirstname());
		}
		if(source.getLastname()!=null) {
			professor.setLastname(source.getLastname());
		}
		if(source.getAddress()!=null) {
			professor.setAddress(source.getAddress());
		}
		if(source.getCity()!=null) {
			professor.setCity(source.getCity());
		}
		if(source.getCountry()!=null) {
			professor.setCountry(source.getCountry());
		}
		if(source.getZip()!=null) {
			professor.setZip(source.getZip());
		}
		if(source.getBirthDate()!=null) {
			professor.setBirthdate(source.getBirthDate());
		}
		if(source.getEmail()!=null) {
			professor.setEmail(source.getEmail());
		}
		if(source.getPhone()!=null) {
			professor.setPhone(source.getPhone());
		}
		if(source.getRole()!=null) {
			professor.setRole(source.getRole());
		}
		if(source.getUser()!=null) {
			professor.setUser(userDTOtoUser.convert(source.getUser()));
		}
		return professor;
	}

}
