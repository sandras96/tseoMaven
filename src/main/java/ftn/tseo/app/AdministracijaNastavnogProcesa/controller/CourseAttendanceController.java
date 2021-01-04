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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.CAttendanceDTOtoCAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.CAttendanceToCAttendanceDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseAttendanceDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseAttendanceService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;

@RestController
@RequestMapping(value="api/courseAttendances")
public class CourseAttendanceController {
	
	@Autowired
	CourseAttendanceService courseAttendanceService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CAttendanceDTOtoCAttendance cAttendanceDTOtoCAttendance;
	
	@Autowired
	CAttendanceToCAttendanceDTO cAttendanceToCAttendanceDTO; 
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<CourseAttendanceDTO>> getAllCAs(){
		List<CourseAttendance> courseattendances = courseAttendanceService.findAll();
		List<CourseAttendanceDTO> courseattendancesDTO = new ArrayList<CourseAttendanceDTO>();
		for(CourseAttendance ca : courseattendances) {
				System.out.println("ca jee: " + ca.getId());
				courseattendancesDTO.add(new CourseAttendanceDTO(ca));
		}
		System.out.println("lista je "+ courseattendancesDTO.toString());
		return new ResponseEntity<>(courseattendancesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CourseAttendanceDTO> saveCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO){
	//	CourseAttendance courseAttendance = courseAttendanceService.save(cAttendanceDTOtoCAttendance.convert(courseAttendanceDTO));
			System.out.println("CA DTO JE " + courseAttendanceDTO);
		  CourseAttendance courseAttendance = new CourseAttendance();
		  courseAttendance.setCourse(courseService.findOne(courseAttendanceDTO.getCourse().getId())); 
		  System.out.println("KURS JE" + courseAttendance.getCourse().toString());
		  courseAttendance.setStudent(studentService.findOne(courseAttendanceDTO.getStudent().getId()));
		  
		  System.out.println("STUDENT JE " + courseAttendance.getStudent().getIndexNum());
		  courseAttendanceService.save(courseAttendance); 
		  System.out.println("CAAA je "+ courseAttendance.toString()); 
		
		 
		System.out.println("COURSE ATT" + courseAttendance);
		return new ResponseEntity<>(cAttendanceToCAttendanceDTO.convert(courseAttendance), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(value="/course/{id}", method = RequestMethod.GET)
	    public ResponseEntity<List<CourseAttendanceDTO>> getCourseAttendanceByCourse(@PathVariable("id") Integer id){
		 	List<CourseAttendance> courseAttendances =courseAttendanceService.findCourseAttendanceByCourseId(id);
	        List<CourseAttendanceDTO> cAttendancesDTO = new ArrayList<>();
	            for (CourseAttendance ca : courseAttendances) {
	            		cAttendancesDTO.add(new CourseAttendanceDTO(ca));
	            	}
	         
	        return new ResponseEntity<List<CourseAttendanceDTO>>(cAttendancesDTO,HttpStatus.OK);
	    }
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<CourseAttendanceDTO>> getCourseAttendanceByStudent(@PathVariable("id") Integer id){
	 	List<CourseAttendance> courseAttendances =courseAttendanceService.findCourseAttendanceByStudentId(id);
        List<CourseAttendanceDTO> cAttendancesDTO = new ArrayList<>();
            for (CourseAttendance ca : courseAttendances) {
            		cAttendancesDTO.add(new CourseAttendanceDTO(ca));
            	}
         
        return new ResponseEntity<List<CourseAttendanceDTO>>(cAttendancesDTO,HttpStatus.OK);
    }

}
