package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.CourseDTOtoCourse;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.CourseToCourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseService;

@RestController
@RequestMapping(value="api/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseDTOtoCourse courseDTOtoCourse;
	
	@Autowired
	CourseToCourseDTO  courseToCourseDTO;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getAllCourses(){
		List<Course> courses = courseService.findAll();
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		for(Course course : courses) {
			System.out.println("course je :" + course.getName());
			coursesDTO.add(new CourseDTO(course));
		}
		System.out.println("lista je "+ coursesDTO.toString());
		return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer id){
		Course course = courseService.findOne(id);
		System.out.println("Course JE " + course);
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO){
		Course course = courseService.save(courseDTOtoCourse.convert(courseDTO));
		
		System.out.println("COURSE JE" + course);
		return new ResponseEntity<>(courseToCourseDTO.convert(course), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO){
		Course course = courseService.findOne(courseDTO.getId());
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		course = courseService.save(courseDTOtoCourse.convert(courseDTO));
		return new ResponseEntity<>(courseToCourseDTO.convert(course), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Integer id){
		Course course = courseService.findOne(id);
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			courseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
}
