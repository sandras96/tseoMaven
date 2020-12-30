package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.UserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Authority;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.AuthorityRepository;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.AuthorityService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.UserService;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserDTOtoUser userDTOtoUser;

	@Autowired
	UserToUserDTO userToUserDTO;

	@Autowired
	AuthorityService authorityService;

	@Autowired
	AuthorityRepository authorityRepository;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User user : users) {
			usersDTO.add(new UserDTO(user));
		}
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
		User user = userService.findOne(id);
		System.out.println("USER JE " + user);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		User username = userService.getByUsername(userDTO.getUsername());
		System.out.println("USER username je " + username);
		if (username != null) {
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		User user = new User();
		user = userDTOtoUser.convert(userDTO);

		System.out.println("AUthorities su: " + userDTO.getAuthorities());

		String string = "";
		Set<Authority> aa = new HashSet<>();
		for (Authority a : userDTO.getAuthorities()) {
			string = a.getName();
			Authority b = authorityRepository.findByName(string);
			aa.add(b);
		}
		user.setUser_authorities(aa);
		userService.save(user);
		System.out.println("USR JE " + user.getId());
		System.out.println("AUTTTT SU " + user.getUser_authorities().size());

		return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/{id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Integer id) {
		User user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("User je koji: " + user.toString());
		user = userDTOtoUser.convert(userDTO);
		String string = "";
		Set<Authority> aa = new HashSet<>();
		for (Authority a : userDTO.getAuthorities()) {
			string = a.getName();
			Authority b = authorityRepository.findByName(string);
			aa.add(b);
		}
		user.setUser_authorities(aa);
		user = userService.save(user);

		System.out.println("User2 je koji: " + user.getUser_authorities() + "usr: " + user.toString());
		return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id) {
		User user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@RequestMapping(value = "student/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserByStudentId(@PathVariable Integer id) {
		User user = userService.getByStudentId(id);
		System.out.println("USER JE " + user);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
}