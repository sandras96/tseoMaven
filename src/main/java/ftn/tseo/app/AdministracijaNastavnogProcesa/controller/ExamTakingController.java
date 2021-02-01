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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ETakingDTOtoETaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ETakingToETakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamTakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamTakingService;

@RestController
@RequestMapping(value="api/examtakings")
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
			examTakingsDTO.add(new ExamTakingDTO(examTaking));
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
		
		return new ResponseEntity<>(new ExamTakingDTO(examTaking), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamTakingDTO> saveExamTaking(@RequestBody ExamTakingDTO examTakingDTO){
		ExamTaking examTaking = examTakingService.save(eTakingDTOtoETaking.convert(examTakingDTO));
		
		System.out.println("EXAM TAKING JE" + examTaking);
		return new ResponseEntity<>(eTakingToETakingDTO.convert(examTaking), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<ExamTakingDTO> updateExamTaking(@RequestBody ExamTakingDTO examTakingDTO, @PathVariable Integer id){
		ExamTaking examTaking = examTakingService.findOne(id);
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
	
	@RequestMapping(value="/student/{id}", method= RequestMethod.GET)
	public ResponseEntity<Set<ExamTakingDTO>> getExamTakingstByStudentId(@PathVariable Integer id){
		Set<ExamTaking> examtakings = examTakingService.findAllByStudentId(id);
		Set<ExamTakingDTO> examtakingsDTO = new HashSet<ExamTakingDTO>();
		for(ExamTaking examTaking : examtakings) {
			System.out.println("examtaking je :" + examTaking.getPoints());
			examtakingsDTO.add(new ExamTakingDTO(examTaking));
		}
		System.out.println("lista je "+examtakingsDTO.toString());
		return new ResponseEntity<>(examtakingsDTO, HttpStatus.OK);
	}
	@RequestMapping(value="/exam/{id}", method= RequestMethod.GET)
	public ResponseEntity<Set<ExamTakingDTO>> getExamTakingstByExamId(@PathVariable Integer id){
		Set<ExamTaking> examtakings = examTakingService.findAllByExamId(id);
		Set<ExamTakingDTO> examtakingsDTO = new HashSet<ExamTakingDTO>();
		for(ExamTaking examTaking : examtakings) {
			System.out.println("examtaking je :" + examTaking.getPoints());
			examtakingsDTO.add(new ExamTakingDTO(examTaking));
		}
		System.out.println("lista je "+examtakingsDTO.toString());
		return new ResponseEntity<>(examtakingsDTO, HttpStatus.OK);
	}
	
}
