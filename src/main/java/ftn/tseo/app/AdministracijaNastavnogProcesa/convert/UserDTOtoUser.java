package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.UserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

@Component
public class UserDTOtoUser implements Converter<UserDTO, User> {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User convert(UserDTO source) {
		if(source == null) {
			return null;
		}
		User user = new User();
		user.setId(source.getId());
		
		if(source.getUsername()!=null) {
			user.setUsername(source.getUsername());
		}
		if(source.getPassword() != null)
			user.setPassword(passwordEncoder.encode(source.getPassword()));
		
		if(!source.isDeleted()) { 
			user.setDeleted(false);
		}
		
		if(source.getAuthorities()!=null) {
			user.setUser_authorities(source.getAuthorities());
		}
		 
		return user;
	}



}