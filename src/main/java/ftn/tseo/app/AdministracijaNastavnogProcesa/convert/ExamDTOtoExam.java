package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;

@Component
public class ExamDTOtoExam implements Converter<ExamDTO, Exam>{

	@Autowired
	CourseDTOtoCourse courseDTOtoCourse;
	
	@Autowired
	EPeriodDTOtoEPeriod ePeriodDTOtoEPeriod;
	
	@Override
	public Exam convert(ExamDTO source) {
		if(source == null) {
			return null;
		}
		Exam exam = new Exam();
		exam.setId(source.getId());
		if(source.getPoints()!=0) {
			exam.setPoints(source.getPoints());
		}
		if(source.getDate()!=null) {
			exam.setDate(source.getDate());
		}
		if(source.getAssignment()!=null) {
			exam.setAssignment(source.getAssignment());
		}
//		if(source.getCourse()!=null) {
//			exam.setCourse(courseDTOtoCourse.convert(source.getCourse()));
//		}
//		if(source.getExamPeriod()!=null) {
//			exam.setExamPeriod(ePeriodDTOtoEPeriod.convert(source.getExamPeriod()));
//		}
		return exam;
	}
	
	

}
