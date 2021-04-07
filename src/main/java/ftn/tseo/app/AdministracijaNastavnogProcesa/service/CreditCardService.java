package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.CreditCardRepository;

@Service
public class CreditCardService {
	
	@Autowired
	CreditCardRepository creditCardRepository;

}
