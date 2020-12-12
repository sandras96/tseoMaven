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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ExamDTOtoExam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ExamToExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamService;

@RestController
@RequestMapping(value="api/exams")
public class ExamController {
	
	@Autowired
	ExamService examService;
	
	@Autowired
	ExamDTOtoExam examDTOtoExam;
	
	@Autowired
	ExamToExamDTO examToExamDTO;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getAllExams(){
		List<Exam> exams = examService.findAll();
		List<ExamDTO> examsDTO = new ArrayList<ExamDTO>();
		for(Exam exam : exams) {
			System.out.println("exam je :" + exam.getPoints());
			examsDTO.add(new ExamDTO(exam));
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
		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamDTO> saveExam(@RequestBody ExamDTO examDTO){
		Exam exam = examService.save(examDTOtoExam.convert(examDTO));
		
		System.out.println("EXAM JE" + exam);
		return new ResponseEntity<>(examToExamDTO.convert(exam), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO){
		Exam exam = examService.findOne(examDTO.getId());
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

}
