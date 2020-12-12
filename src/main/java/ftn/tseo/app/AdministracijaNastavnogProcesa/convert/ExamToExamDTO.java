package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

@Component
public class ExamToExamDTO implements Converter<Exam, ExamDTO>{

	@Autowired
	CourseToCourseDTO courseToCourseDTO;
	
	@Autowired
	EPeriodToEPeriodDTO ePeriodToEPeriodDTO;
	
	@Override
	public ExamDTO convert(Exam source) {
		
		if(source == null) {
			return null;
		}
		ExamDTO examDTO = new ExamDTO();
		examDTO.setId(source.getId());
		if(source.getPoints()!=0) {
			examDTO.setPoints(source.getPoints());
		}
		if(source.getDate()!=null) {
			examDTO.setDate(source.getDate());
		}
		if(source.getAssignment()!=null) {
			examDTO.setAssignment(source.getAssignment());
		}
		if(source.getCourse()!=null) {
			examDTO.setCourse(courseToCourseDTO.convert(source.getCourse()));
		}
		if(source.getExamPeriod()!=null) {
			examDTO.setExamPeriod(ePeriodToEPeriodDTO.convert(source.getExamPeriod()));
		}
		return examDTO;
	}

}
