package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamTakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;

@Component
public class ETakingToETakingDTO implements Converter<ExamTaking, ExamTakingDTO>{

	@Autowired
	ExamToExamDTO examToExamDTO;
	@Autowired
	ProfessorToProfessorDTO professorToProfessorDTO;
	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@Override
	public ExamTakingDTO convert(ExamTaking source) {
		if(source==null) {
			return null;
		}
		ExamTakingDTO examTakingDTO = new ExamTakingDTO();
		examTakingDTO.setId(source.getId());
		if(source.getPoints()!=0) {
			examTakingDTO.setPoints(source.getPoints());
		}
		if(!source.isPass()) {
			examTakingDTO.setPass(source.isPass());
		}
		if(source.getMark()!=null) {
			examTakingDTO.setMark(source.getMark());
		}
		if(source.getExam()!=null) {
			examTakingDTO.setExam(examToExamDTO.convert(source.getExam()));
		}
		if(source.getProfessor()!=null) {
			examTakingDTO.setProfessor(professorToProfessorDTO.convert(source.getProfessor()));
		}
		if(source.getStudent()!=null) {
			examTakingDTO.setStudent(studentToStudentDTO.convert(source.getStudent()));
		}
		return examTakingDTO;
	}

}
