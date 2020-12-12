package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;

@Component
public class ProfessorToProfessorDTO implements Converter<Professor, ProfessorDTO>{

	@Autowired
	UserToUserDTO userToUserDTO;
	
	@Override
	public ProfessorDTO convert(Professor source) {
		if(source == null) {
			return null;
		}
		ProfessorDTO professorDTO = new ProfessorDTO();
		professorDTO.setId(source.getPerson_id());
		
		if(source.getFirstname()!=null) {
			professorDTO.setFirstname(source.getFirstname());
		}
		if(source.getLastname()!=null) {
			professorDTO.setLastname(source.getLastname());
		}
		if(source.getAddress()!=null) {
			professorDTO.setAddress(source.getAddress());
		}
		if(source.getCity()!=null) {
			professorDTO.setCity(source.getCity());
		}
		if(source.getCountry()!=null) {
			professorDTO.setCountry(source.getCountry());
		}
		if(source.getZip()!=null) {
			professorDTO.setZip(source.getZip());
		}
		if(source.getBirthdate()!=null) {
			professorDTO.setBirthdate(source.getBirthdate());
		}
		if(source.getEmail()!=null) {
			professorDTO.setEmail(source.getEmail());
		}
		if(source.getPhone()!=null) {
			professorDTO.setPhone(source.getPhone());
		}
		if(source.getRole()!=null) {
			professorDTO.setRole(source.getRole());
		}
		if(source.getUser()!=null) {
			professorDTO.setUser(userToUserDTO.convert(source.getUser()));
		}
		return professorDTO;
	}

}
