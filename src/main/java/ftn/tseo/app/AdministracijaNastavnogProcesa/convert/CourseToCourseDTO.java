package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;

@Component
public class CourseToCourseDTO implements Converter<Course, CourseDTO>{

	@Override
	public CourseDTO convert(Course source) {
		
		if(source == null) {
			return null;
		}
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(source.getId());
		
		if(source.getName()!=null) {
			courseDTO.setName(source.getName());
		}
		if(source.getEspb()!=0) {
			courseDTO.setEspb(source.getEspb());
		}
		if(source.getSemester()!=null) {
			courseDTO.setSemester(source.getSemester());
		}
		if(!source.isDeleted()) {
			courseDTO.setDeleted(source.isDeleted());
		}
		
		return courseDTO;
	}

}
