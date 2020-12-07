package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.UserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

public class UserDTOtoUser implements Converter<UserDTO, User> {

	@Override
	public User convert(UserDTO source) {
		if(source == null) {
			return null;
		}
		User user = new User();

		if(source.getUsername()!=null) {
			user.setUsername(source.getUsername());
		}
		if(source.getPassword()!=null) {
			user.setPassword(source.getPassword());
		}
		
		if(!source.isDeleted()) {
			user.setDeleted(source.isDeleted());
		}
		return user;
	}



}
