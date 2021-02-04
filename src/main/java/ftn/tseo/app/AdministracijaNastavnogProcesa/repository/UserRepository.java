package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User getByUsername(String username);
	
	@Query(value="select u.* from user u left join student s on s.user_rel = u.user_id where s.student_id = ?", nativeQuery = true)
	User getByStudentId(Integer id);
	
	@Query(value="SELECT u.* FROM user u JOIN user_authority ua ON u.user_id = ua.user_id JOIN authority a ON ua.authority_id = a.id WHERE a.name LIKE ?", nativeQuery = true)
	List<User> findByAuthority(String name);
}
