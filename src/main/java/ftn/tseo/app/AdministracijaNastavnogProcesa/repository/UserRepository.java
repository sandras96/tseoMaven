package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User getByUsername(String username);
	

}
