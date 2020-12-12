package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamTakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;

@Component
public class ETakingDTOtoETaking implements Converter<ExamTakingDTO, ExamTaking>  {

	@Autowired
	ExamDTOtoExam examDTOtoExam;
	@Autowired 
	ProfessorDTOtoProfessor professorDTOtoProfessor;
	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;
	
	@Override
	public ExamTaking convert(ExamTakingDTO source) {
		if(source==null) {
			return null;
		}
		ExamTaking examTaking = new ExamTaking();
		examTaking.setId(source.getId());
		if(source.getPoints()!=0) {
			examTaking.setPoints(source.getPoints());
		}
		if(!source.isPass()) {
			examTaking.setPass(source.isPass());
		}
		if(source.getMark()!=null) {
			examTaking.setMark(source.getMark());
		}
		if(source.getExam()!=null) {
			examTaking.setExam(examDTOtoExam.convert(source.getExam()));
		}
		if(source.getProfessor()!=null) {
			examTaking.setProfessor(professorDTOtoProfessor.convert(source.getProfessor()));
		}
		if(source.getStudent()!=null) {
			examTaking.setStudent(studentDTOtoStudent.convert(source.getStudent()));
		}
		return examTaking;
	}

}
