package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ExamDTOtoExam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ExamToExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseAttendanceService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamPeriodService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamTakingService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ProfessorService;

@RestController
@RequestMapping(value="api/exams")
public class ExamController {
	
	@Autowired
	ExamService examService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamPeriodService examPeriodService;
	
	@Autowired
	CourseAttendanceService courseAttendanceService;
	
	@Autowired
	ExamDTOtoExam examDTOtoExam;
	
	@Autowired
	ExamToExamDTO examToExamDTO;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getAllExams(){
		List<Exam> exams = examService.findAll();
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
				System.out.println("exam je :" + exam.getPoints());
				examsDTO.add(new ExamDTO(exam));
			}
			
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamDTO> getExamById(@PathVariable Integer id){
		Exam exam = examService.findOne(id);
		System.out.println("EXAM JE " + exam);
		if(exam == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(exam.getCourse().isDeleted() || exam.getExamPeriod().isDeleted()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{cId}/{epId}", consumes="application/json")
	public ResponseEntity<ExamDTO> saveExam(@RequestBody ExamDTO examDTO, @PathVariable Integer cId, @PathVariable Integer epId){
		Exam exam = new Exam();
		exam = examDTOtoExam.convert(examDTO);
		Course course = courseService.findOne(cId);
		exam.setCourse(course);
		ExamPeriod examPeriod = examPeriodService.findOne(epId);
		exam.setExamPeriod(examPeriod);
		examService.save(exam);
		
		System.out.println("EXAM JE" + exam);
		return new ResponseEntity<>(examToExamDTO.convert(exam), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO examDTO){
		System.out.println("exam koji sam dobila iz forme je " + examDTO.toString());
		Exam exam = new Exam();
		exam = examDTOtoExam.convert(examDTO);
		examService.save(exam);
		
		System.out.println("EXAM JE" + exam);
		return new ResponseEntity<>(examToExamDTO.convert(exam), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO, @PathVariable("id") Integer id){
		Exam exam = examService.findOne(id);
		if(exam == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		exam = examService.save(examDTOtoExam.convert(examDTO));
		return new ResponseEntity<>(examToExamDTO.convert(exam), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ExamDTO> deleteExam(@PathVariable Integer id){
		Exam exam = examService.findOne(id);
		if(exam == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			examService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/examPeriod/{id}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getAllExamsByExamPeriodId(@PathVariable Integer id){
		List<Exam> exams = examService.findAllByExamPeriodId(id);
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
				System.out.println("exam je :" + exam.getPoints());
				examsDTO.add(new ExamDTO(exam));
			}
			
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	@RequestMapping(value="/student/{id}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExamByStudentId(@PathVariable Integer id){
		
		List<Exam> exams = examService.findAll();
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		List<CourseAttendance> courseAttendances = courseAttendanceService.findCourseAttendanceByStudentId(id);
		for(CourseAttendance courseAttendance : courseAttendances) {
			for(Exam exam : exams) {
				if(courseAttendance.getCourse().getId()==exam.getCourse().getId()) {
					if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
						examsDTO.add(new ExamDTO(exam));
					}
					
				}
			}
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
/*	@RequestMapping(value="/student/{id}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExamByStudentId2(@PathVariable Integer id){
		
		List<Exam> exams = examService.getAllUnregisteredExams();
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		List<CourseAttendance> courseAttendances = courseAttendanceService.findCourseAttendanceByStudentId(id);
		for(CourseAttendance courseAttendance : courseAttendances) {
			for(Exam exam : exams) {
				if(courseAttendance.getCourse().getId()==exam.getCourse().getId()) {
					if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
						examsDTO.add(new ExamDTO(exam));
					}
					
				}
			}
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	*/
	@RequestMapping(value="/professor/{id}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExamByProfessorId(@PathVariable Integer id){
		List<Exam> exams = examService.findAll();
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		List<Course> courses = courseService.getAllByProfessorId(id);
		for(Course course : courses){
			for(Exam exam : exams) {
				if(course.getId() == exam.getCourse().getId()) {
					examsDTO.add(new ExamDTO(exam));
				}
			}
		}
		
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
	
///////////////////////////////////// SEARCH////////////////////////////////////////	
	
	@RequestMapping(value="/searchByExamPeriod/{name}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> searchByExamPeriodName(@PathVariable("name") String name){
		List<Exam> exams = examService.findByExamPeriodName(name);
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
				System.out.println("exam je :" + exam.getPoints());
				examsDTO.add(new ExamDTO(exam));
			}
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	@RequestMapping(value="/searchByExamPeriodAndCourse/{name}/{id}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> searchByExamPeriodNameAndCourse(@PathVariable("name") String name, @PathVariable("id") Integer id){
		List<Exam> exams = examService.findByExamPeriodNameAndCourse(name, id);
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
				System.out.println("exam je :" + exam.getPoints());
				examsDTO.add(new ExamDTO(exam));
			}
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/searchByCourse/{name}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> searchByCourseName(@PathVariable("name") String name){
		List<Exam> exams = examService.findByCourseName(name);
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
				System.out.println("exam je :" + exam.getPoints());
				examsDTO.add(new ExamDTO(exam));
			}
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	@RequestMapping(value="/searchByCourseAndExamPeriod/{name}/{id}", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> searchByCourseNameAndExamPeriod(@PathVariable("name") String name, @PathVariable("id") Integer id){
		List<Exam> exams = examService.findByCourseNameAndExamPeriod(name, id);
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			if(!exam.getCourse().isDeleted() && !exam.getExamPeriod().isDeleted()) {
				System.out.println("exam je :" + exam.getPoints());
				examsDTO.add(new ExamDTO(exam));
			}
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
	
	
}
