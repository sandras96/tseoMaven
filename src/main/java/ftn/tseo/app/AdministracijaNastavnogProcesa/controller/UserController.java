package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserDTOtoUser;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserToUserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.UserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.UserService;

@RestController
@RequestMapping(value="api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDTOtoUser userDTOtoUser;
	
	@Autowired
	UserToUserDTO userToUserDTO;
	
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user : users) {
			usersDTO.add(new UserDTO(user));
		}
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}
	

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
		User user = userService.findOne(id);
		System.out.println("USER JE " + user);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
		User user = userService.save(userDTOtoUser.convert(userDTO));
			
		System.out.println("USR JE" + user);
		return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.CREATED);
			
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
		User user = userService.findOne(userDTO.getId());
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		user = userService.save(userDTOtoUser.convert(userDTO));
		return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id){
		User user = userService.findOne(id);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			userService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
}
