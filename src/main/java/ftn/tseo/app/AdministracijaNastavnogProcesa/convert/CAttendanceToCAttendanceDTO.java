package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseAttendanceDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;

@Component
public class CAttendanceToCAttendanceDTO implements Converter<CourseAttendance, CourseAttendanceDTO>{
	
	@Autowired
	CourseToCourseDTO courseToCourseDTO;
	
	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@Override
	public CourseAttendanceDTO convert(CourseAttendance source) {
		if(source == null) {
			return null;
		}
		CourseAttendanceDTO ca = new CourseAttendanceDTO();
		ca.setId(source.getId());
		if(source.getCourse()!=null) {
			ca.setCourse(courseToCourseDTO.convert(source.getCourse()));
		}
		if(source.getStudent()!=null) {
			ca.setStudent(studentToStudentDTO.convert(source.getStudent()));
		}
		return ca;
	}

}
