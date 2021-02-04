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
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentToStudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course.Semester;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.CourseRepository;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseAttendanceService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;

@RestController
@RequestMapping(value="api/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamService examService;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@Autowired
	CourseAttendanceService courseAttendanceService;
	
	@Autowired
	CourseDTOtoCourse courseDTOtoCourse;
	
	@Autowired
	CourseToCourseDTO  courseToCourseDTO;
	
	
	@RequestMapping(value="/all",  method= RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getAllCourses(){
		List<Course> courses = courseService.findAll();
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		for(Course course : courses) {
			if(!course.isDeleted()) {
				System.out.println("course je :" + course.getName());
				coursesDTO.add(new CourseDTO(course));
			}
			
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
		if(course.isDeleted()) {
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
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO, @PathVariable("id") Integer id){
		Course course = courseService.findOne(id);
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		course = courseService.save(courseDTOtoCourse.convert(courseDTO));
		return new ResponseEntity<>(courseToCourseDTO.convert(course), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
		Course course = courseService.findOne(id);
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			course.setDeleted(true);
			courseService.save(course);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getCoursesByStudent(@PathVariable("id") Integer id){
	 	List<CourseAttendance> courseAttendances =courseAttendanceService.findCourseAttendanceByStudentId(id);
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
            for (CourseAttendance ca : courseAttendances) {
            	if(ca.getStudent() == studentService.findOne(id)) {
            		if(!ca.getCourse().isDeleted()) {
            			CourseDTO courseDTO = courseToCourseDTO.convert(ca.getCourse());
                		coursesDTO.add(courseDTO);
            		}
            	}
            }
         
        return new ResponseEntity<List<CourseDTO>>(coursesDTO,HttpStatus.OK);
    }
	
	@RequestMapping(value="/student/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> getStudentsByCourseId(@PathVariable("id") Integer id){
		System.out.println("Usao sam u listu studenata za odabrani kurs");
		Course course = courseService.findOne(id);
		if(course==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	 	List<CourseAttendance> courseAttendances =courseAttendanceService.findCourseAttendanceByCourseId(id);
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
            for (CourseAttendance ca : courseAttendances) {
            	if(ca.getCourse() == courseService.findOne(id)) {
            		StudentDTO studentDTO = studentToStudentDTO.convert(ca.getStudent());
            		if(!studentDTO.getUser().isDeleted()) {
            			studentsDTO.add(studentDTO);
            		}
            	}
            }
         
        return new ResponseEntity<List<StudentDTO>>(studentsDTO,HttpStatus.OK);
    }
	
	@RequestMapping(value="/exam/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ExamDTO>> getExamsByCourseId(@PathVariable("id") Integer id){
		System.out.println("Usao sam u listu ispita za odabrani kurs");
		Course course = courseService.findOne(id);
		if(course==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	 	List<Exam> exams = examService.findAllByCourseId(id);
        List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
            for (Exam exam : exams) {
            		if(!exam.getExamPeriod().isDeleted()) {
            			examsDTO.add(new ExamDTO(exam));
            		}
            }
         
        return new ResponseEntity<List<ExamDTO>>(examsDTO,HttpStatus.OK);
    }
	
/////////////////////////////////////// SEARCH ////////////////////////////////////////
	
	@RequestMapping(value="/searchByName/{name}")
	public ResponseEntity<List<CourseDTO>> searchByName(@PathVariable("name") String name) throws Exception {
		System.out.println("pretraga po imenu coursa: " + name);
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		List<Course> courses = new ArrayList<Course>();
		courses = courseService.findByNameContaining(name);
		System.out.println("Lista kurseva sa imenom: "+ name + " " + courses);
		for(Course course : courses) {
			if(!course.isDeleted()) {
				coursesDTO.add(new CourseDTO(course));
			}
			
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO,HttpStatus.OK);
	}
	@RequestMapping(value="/searchBySemester/{semester}")
	public ResponseEntity<List<CourseDTO>> searchBySemester(@PathVariable("semester") String semester) throws Exception {
		System.out.println("pretraga po semester coursa: " + semester);
		String s = "%"+semester+"%";
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();	
		List<Course> courses = courseService.findBySemesterContaining(s);
		System.out.println("Lista kurseva sa semestrom: "+ semester + " " + courses);
		for(Course course : courses) {
			if(!course.isDeleted()) {
				coursesDTO.add(new CourseDTO(course));
			};
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/searchByEspb/{espb}")
	public ResponseEntity<List<CourseDTO>> searchByEspb(@PathVariable("espb") float espb) throws Exception {
		System.out.println("pretraga po espb coursa: " + espb);
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();	
		List<Course> courses = courseService.findByEspb(espb);
		System.out.println("Lista kurseva sa semestrom: "+ espb + " " + courses);
		for(Course course : courses) {
			if(!course.isDeleted()) {
				coursesDTO.add(new CourseDTO(course));
			}
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO,HttpStatus.OK);
	}
	
}
