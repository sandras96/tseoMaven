package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;

@Component
public class CourseDTOtoCourse implements Converter<CourseDTO, Course> {

	@Override
	public Course convert(CourseDTO source) {
		if(source==null) {
			return null;
		}
		Course course = new Course();
		course.setId(source.getId());
		if(source.getName()!=null) {
			course.setName(source.getName());
		}
		if(source.getEspb()!=0) {
			course.setEspb(source.getEspb());
		}
		if(source.getSemester()!=null) {
			course.setSemester(source.getSemester());
		}
		if(!source.isDeleted()) {
			course.setDeleted(source.isDeleted());
		}
		return course;
	}

}
