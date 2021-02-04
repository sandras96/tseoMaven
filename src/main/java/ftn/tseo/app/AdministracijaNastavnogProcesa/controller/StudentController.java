package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentDTOtoStudent;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentToStudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserDTOtoUser;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserToUserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Authority;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.AuthorityRepository;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.DocumentService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.UserService;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	UserService userService;

	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;

	@Autowired
	StudentToStudentDTO studentToStudentDTO;

	@Autowired
	UserDTOtoUser userDTOtoUser;

	@Autowired
	UserToUserDTO userToUserDTO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	AuthorityRepository authorityRepository;

	@Autowired
	DocumentService documentService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		List<Student> students = studentService.findAll();
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		for (Student student : students) {
			if(!student.getUser().isDeleted()) {
				System.out.println("student je :" + student.getIndexNum());
				studentsDTO.add(new StudentDTO(student));
			}
			
		}
		System.out.println("lista je " + studentsDTO.toString());
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) {
		Student student = studentService.findOne(id);
		System.out.println("STUDENT JE " + student);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(student.getUser().isDeleted()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
		Student student1 = studentService.findByIndexNum(studentDTO.getIndexNum());
		if (student1 != null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.FORBIDDEN);
		}
		Student student = new Student();

		student = studentDTOtoStudent.convert(studentDTO);
		User user = new User();
		user.setUsername(studentDTO.getUser().getUsername());
		user.setPassword(passwordEncoder.encode(studentDTO.getUser().getPassword()));
		user.setDeleted(false);
		String string = "";
		Set<Authority> aa = new HashSet<>();
		for (Authority a : studentDTO.getUser().getAuthorities()) {
			string = a.getName();
			Authority b = authorityRepository.findByName(string);
			aa.add(b);
		}
		user.setUser_authorities(aa);

		userService.save(user);
		System.out.println("Authorities su " + user.getUser_authorities());

		student.setUser(userService.findOne(user.getId()));
		studentService.save(student);
		System.out.println("USER JE " + student.getUser().getId());

		return new ResponseEntity<>(studentToStudentDTO.convert(student), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable("id") Integer id) {
		Student student = studentService.findOne(id);
		System.out.println("student JE " + student);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		student = studentDTOtoStudent.convert(studentDTO);
		
		System.out.println("USER JE " + student.getUser().getPassword());

//		User user = userService.findOne(studentDTO.getUser().getId());
//		String string = "";
//		Set<Authority> aa = new HashSet<>();
//		for (Authority a : studentDTO.getUser().getAuthorities()) {
//			string = a.getName();
//		Authority b = authorityRepository.findByName(string);
//			aa.add(b);
//		}
//		user.setUser_authorities(aa);
//		user.setPassword(student.getUser().getPassword());
//		student.setUser(userDTOtoUser.convert(studentDTO.getUser())); 
		studentService.save(student);

		return new ResponseEntity<>(studentToStudentDTO.convert(student), HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Integer id) {
		Student student = studentService.findOne(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("STUDENT ZA BRISANJE JE " + student.getPerson_id());
			User user = userService.getByStudentId(id);
			user.setDeleted(true);
			userService.save(user);
		//	studentService.deleteStudentById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentByUserId(@PathVariable Integer id) {
		Student student = studentService.findByUserId(id);
		System.out.println("STUDENT JE " + student);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
////////////////////////////SEARCH///////////////////////////////////////
	
	@RequestMapping(value = "/searchByFirstname/{firstname}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllByFirstname(@PathVariable("firstname") String firstname) {
		List<Student> students = studentService.findByFirstname(firstname);
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		for (Student student : students) {
			if(!student.getUser().isDeleted()) {
				System.out.println("student je :" + student.getIndexNum());
				studentsDTO.add(new StudentDTO(student));
			}
			
		}
		System.out.println("lista je " + studentsDTO.toString());
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchByLastname/{lastname}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllByLastname(@PathVariable("lastname") String lastname) {
		List<Student> students = studentService.findByLastname(lastname);
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		for (Student student : students) {
			if(!student.getUser().isDeleted()) {
				System.out.println("student je :" + student.getIndexNum());
				studentsDTO.add(new StudentDTO(student));
			}
			
		}
		System.out.println("lista je " + studentsDTO.toString());
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchByIndexnumber/{indexnumber}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllByIndexnumber(@PathVariable("indexnumber") String indexnumber) {
		List<Student> students = studentService.findByIndexnumber(indexnumber);
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		for (Student student : students) {
			if(!student.getUser().isDeleted()) {
				System.out.println("student je :" + student.getIndexNum());
				studentsDTO.add(new StudentDTO(student));
			}
			
		}
		System.out.println("lista je " + studentsDTO.toString());
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	

}
