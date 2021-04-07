package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.FinancialCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FinancialCard;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.FinancialCardService;

@RestController
@RequestMapping(value="api/financialCard")
public class FinancialCardController{

	
	@Autowired
	FinancialCardService financialCardService;
	
	@RequestMapping(value="student/{id}", method = RequestMethod.GET)
	public ResponseEntity<FinancialCardDTO> getCourseById(@PathVariable Integer id){

		FinancialCard financialCard = financialCardService.findByStudent(id);
		if(financialCard == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new FinancialCardDTO(financialCard), HttpStatus.OK);
	}
}
