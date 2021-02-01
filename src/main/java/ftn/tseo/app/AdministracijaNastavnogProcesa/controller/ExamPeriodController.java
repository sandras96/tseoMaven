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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.EPeriodDTOtoEPeriod;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.EPeriodToEPeriodDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamPeriodDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamPeriodService;

@RestController
@RequestMapping(value="api/examPeriods")
public class ExamPeriodController {
	
	@Autowired
	ExamPeriodService examPeriodService;
	
	@Autowired
	EPeriodDTOtoEPeriod ePeriodDTOtoEPeriod;
	
	@Autowired
	EPeriodToEPeriodDTO ePeriodToEPeriodDTO; 
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ExamPeriodDTO>> getExamPeriods(){
		List<ExamPeriod> examPeriods = examPeriodService.findAll();
		List<ExamPeriodDTO> examPeriodsDTO = new ArrayList<ExamPeriodDTO>();
		for(ExamPeriod examPeriod : examPeriods) {
			System.out.println("examPeriod je :" + examPeriod.getName());
			examPeriodsDTO.add(new ExamPeriodDTO(examPeriod));
		}
		System.out.println("lista je "+ examPeriodsDTO.toString());
		return new ResponseEntity<>(examPeriodsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamPeriodDTO> getExamPeriodById(@PathVariable Integer id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		System.out.println("Exam Period JE " + examPeriod);
		if(examPeriod == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamPeriodDTO> saveExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO){
		ExamPeriod examPeriod = examPeriodService.findByName(examPeriodDTO.getName());
		if(examPeriod != null) {
			return new ResponseEntity<ExamPeriodDTO>(HttpStatus.FORBIDDEN);
		}
		 examPeriod = examPeriodService.save(ePeriodDTOtoEPeriod.convert(examPeriodDTO));
		
		System.out.println("EXA, PERIOD  JE" + examPeriod);
		return new ResponseEntity<>(ePeriodToEPeriodDTO.convert(examPeriod), HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<ExamPeriodDTO> updateExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO, @PathVariable("id") Integer id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		examPeriod = examPeriodService.save(ePeriodDTOtoEPeriod.convert(examPeriodDTO));
		return new ResponseEntity<>(ePeriodToEPeriodDTO.convert(examPeriod), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ExamPeriodDTO> deleteExamPeriod(@PathVariable Integer id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			examPeriodService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
}
