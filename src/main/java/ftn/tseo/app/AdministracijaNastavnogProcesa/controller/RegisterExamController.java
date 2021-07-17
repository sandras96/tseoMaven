package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.HashSet;
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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentToStudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;

@RestController
@RequestMapping(value = "api/registerexam")
public class RegisterExamController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ExamService examService;
	
	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<StudentDTO> signUpExam(@RequestBody List<Exam> exams, @PathVariable("id") Integer id){
		System.out.println("Update candidate " + exams + "student id je "+ id);
		Student student = studentService.findOne(id);
		if(student== null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		for(Exam exam : exams) {
			student.addExam(exam);
		}
		studentService.save(student);

		return new ResponseEntity<>(studentToStudentDTO.convert(student), HttpStatus.OK);
	}
	
	@RequestMapping(value="/removeExam/{id}",method=RequestMethod.PUT)
	public ResponseEntity<StudentDTO> removeRegisteredExam(@RequestBody List<Exam> exams, @PathVariable("id") Integer id){
		Student student = studentService.findOne(id);
		if(student== null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		for(Exam exam: exams) {
			student.removeExam(exam);
		}
		studentService.save(student);
		
//		Set<Skill> skills = candidate.getSkills();
//		skills.remove(skill);
//		candidate.setSkills(skills);
//		skill.getCandidates().remove(candidate);
//		
//		candidateService.save(candidate);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/student/{id}", method= RequestMethod.GET)
	public ResponseEntity<Set<ExamDTO>> getRegisteredExams(@PathVariable Integer id){
		
		Student student = studentService.findOne(id);
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Set<Exam> exams = examService.getAllRegisteredExams(id);
		Set<ExamDTO> examsDTO = new HashSet<ExamDTO>();
		
		for(Exam exam : exams) {
			
			examsDTO.add(new ExamDTO(exam));
		}
		System.out.println("lista je "+ examsDTO.toString());
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}

}
