package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course.Semester;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.CourseRepository;

@Service
public class CourseService {

	
	@Autowired
	CourseRepository courseRepository;
	
	public Course findOne(Integer id) {
		return courseRepository.findById(id).orElse(null);
	}

	
	public List<Course> findAll() { 
		return courseRepository.findAll(); 
	}
	 
	
//	public Page<Course> findAll(Pageable pageable) {
//		return courseRepository.findAll(pageable);
//	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public void remove(Integer id) {
		courseRepository.deleteById(id);
	}

	public List<Course> getAllByProfessorId(Integer id) {
		return courseRepository.getAllByProfessorId(id);
	}
	
	
	public List<Course> findByNameContaining(String name){ 
	  return courseRepository.findByNameContaining(name); 
	}
	
	public List<Course> findBySemesterContaining(String semester){ 
		  return courseRepository.findBySemester(semester); 
	}
	 
	public List<Course> findByEspb(Float espb){ 
		  return courseRepository.findByEspb(espb); 
	}
}
