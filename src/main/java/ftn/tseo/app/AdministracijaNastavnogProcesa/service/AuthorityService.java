package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Authority;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.AuthorityRepository;

@Service
public class AuthorityService {
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	public Set<Authority> getAllByUser(String string) {
		return authorityRepository.getAllByUserId(string);
	}

}
