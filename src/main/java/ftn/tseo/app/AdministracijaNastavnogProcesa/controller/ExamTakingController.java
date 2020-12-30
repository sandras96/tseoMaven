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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ETakingDTOtoETaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ETakingToETakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamTakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamTakingService;

@RestController
@RequestMapping(value="api/examTakings")
public class ExamTakingController {
	
	@Autowired 
	ExamTakingService examTakingService;
	
	@Autowired 
	ETakingDTOtoETaking eTakingDTOtoETaking;
	
	@Autowired
	ETakingToETakingDTO eTakingToETakingDTO;
	
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ExamTakingDTO>> getAllExamTakings(){
		List<ExamTaking> examTakings = examTakingService.findAll();
		List<ExamTakingDTO> examTakingsDTO = new ArrayList<ExamTakingDTO>();
		for(ExamTaking examTaking : examTakings) {
			System.out.println("ezam taking je :" + examTaking.getMark());
		//*****	examTakingsDTO.add(new ExamTakingDTO(examTaking));
		}
		System.out.println("lista je "+ examTakingsDTO.toString());
		return new ResponseEntity<>(examTakingsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamTakingDTO> getExamTakingById(@PathVariable Integer id){
		ExamTaking examTaking = examTakingService.findOne(id);
		System.out.println("Exam taking JE " + examTaking);
		if(examTaking == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return null;
	// *****	return new ResponseEntity<>(new ExamTakingDTO(examTaking), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamTakingDTO> saveExamTaking(@RequestBody ExamTakingDTO examTakingDTO){
		ExamTaking examTaking = examTakingService.save(eTakingDTOtoETaking.convert(examTakingDTO));
		
		System.out.println("EXAM TAKING JE" + examTaking);
		return new ResponseEntity<>(eTakingToETakingDTO.convert(examTaking), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ExamTakingDTO> updateExamTaking(@RequestBody ExamTakingDTO examTakingDTO){
		ExamTaking examTaking = examTakingService.findOne(examTakingDTO.getId());
		if(examTaking == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		examTaking = examTakingService.save(eTakingDTOtoETaking.convert(examTakingDTO));
		return new ResponseEntity<>(eTakingToETakingDTO.convert(examTaking), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ExamTakingDTO> deleteExamTaking(@PathVariable Integer id){
		ExamTaking examTaking = examTakingService.findOne(id);
		if(examTaking == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			examTakingService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
}
