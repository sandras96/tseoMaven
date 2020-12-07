package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.UserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;

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
		if(source.getPassword()!=null) {
			userDTO.setPassword(source.getPassword());
		}
		if(!source.isDeleted()) {
			userDTO.setDeleted(source.isDeleted());;
		}
		return userDTO;
	}

}
