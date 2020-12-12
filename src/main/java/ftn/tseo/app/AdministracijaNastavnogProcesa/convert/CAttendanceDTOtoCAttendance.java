package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseAttendanceDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;

@Component
public class CAttendanceDTOtoCAttendance implements Converter<CourseAttendanceDTO, CourseAttendance> {

	@Autowired
	CourseDTOtoCourse courseDTOtoCourse;
	
	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;
	
	@Override
	public CourseAttendance convert(CourseAttendanceDTO source) {
		if(source == null) {
			return null;
		}
		CourseAttendance ca = new CourseAttendance();
		ca.setId(source.getId());
		if(source.getCourse()!=null) {
			ca.setCourse(courseDTOtoCourse.convert(source.getCourse()));
		}
		if(source.getStudent()!=null) {
			ca.setStudent(studentDTOtoStudent.convert(source.getStudent()));
		}
		return ca;
	}

}
