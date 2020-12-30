package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

//	@Query(value = "SELECT * FROM authority a WHERE a.name= ?1",nativeQuery = true)
//	Authority getPlz(String name);
	
	@Query(value = "SELECT a.* FROM authority a JOIN user_authority au ON a.id = au.authority_id JOIN user u ON u.user_id = au.user_id WHERE u.username = ?;",nativeQuery = true)
	Set<Authority> getAllByUserId(String string);
	
	Authority findByName(String name);

}
