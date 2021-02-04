package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.UserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

	
	@Override
	public UserDTO convert(User source) {
		if(source == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(source.getId());
		
		if(source.getUsername()!=null) {
			userDTO.setUsername(source.getUsername());
		}
	//	if(source.getPassword()!=null) {
	//		userDTO.setPassword(source.getPassword());
	//		}
	
		if(!source.isDeleted()) { 
			userDTO.setDeleted(source.isDeleted()); }
		
		if(source.getUser_authorities() != null) {
			userDTO.setAuthorities(source.getUser_authorities());
		 }
		return userDTO;
	}

}