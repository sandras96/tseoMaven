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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ProfessorDTOtoProfessor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ProfessorToProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ProfessorService;

@RestController
@RequestMapping(value="api/professors")
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	ProfessorDTOtoProfessor professorDTOtoProfessor;
	
	@Autowired
	ProfessorToProfessorDTO professorToProfessorDTO;
	

	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> getAllProfessors(){
		List<Professor> professors = professorService.findAll();
		List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
		for(Professor professor : professors) {
			System.out.println("professor je :" + professor.getFirstname());
			professorsDTO.add(new ProfessorDTO(professor));
		}
		System.out.println("lista je "+ professorsDTO.toString());
		return new ResponseEntity<>(professorsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Integer id){
		Professor professor = professorService.findOne(id);
		System.out.println("PROFESSOR JE " + professor);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ProfessorDTO(professor), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ProfessorDTO> saveProfessor(@RequestBody ProfessorDTO professorDTO){
		Professor professor = professorService.save(professorDTOtoProfessor.convert(professorDTO));
			
		System.out.println("PROFESSOR JE" + professor);
		return new ResponseEntity<>(professorToProfessorDTO.convert(professor), HttpStatus.CREATED);
			
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO professorDTO){
		Professor professor = professorService.findOne(professorDTO.getId());
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		professor = professorService.save(professorDTOtoProfessor.convert(professorDTO));
		return new ResponseEntity<>(professorToProfessorDTO.convert(professor), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ProfessorDTO> deleteProfessor(@PathVariable Integer id){
		Professor professor = professorService.findOne(id);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			professorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
}
