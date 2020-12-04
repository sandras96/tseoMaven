package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.AssignmentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Assignment;

public class AssignmentDTOtoAssignment implements Converter<AssignmentDTO, Assignment> {

	@Autowired
	
	
	@Override
	public Assignment convert(AssignmentDTO source) {
		if(source == null) {
			return null;
		}
		Assignment a = new Assignment();
		a.setId(source.getId());
		if(source.getName() !=null) {
			a.setName(source.getName());
		}
		if(source.getPoints()>0) {
			a.setPoints(source.getPoints());
		}
		if(source.getExam()!=null) {
			
		}
		
		return null;
	}

}
