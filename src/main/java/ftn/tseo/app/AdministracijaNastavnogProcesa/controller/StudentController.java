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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentDTOtoStudent;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.StudentToStudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserDTOtoUser;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserToUserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.UserService;

@RestController
@RequestMapping(value="api/students")
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
	
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudents(){
		List<Student> students = studentService.findAll();
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		for(Student student : students) {
			System.out.println("student je :" + student.getFirstname());
			studentsDTO.add(new StudentDTO(student));
		}
		System.out.println("lista je "+ studentsDTO.toString());
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id){
		Student student = studentService.findOne(id);
		System.out.println("STUDENT JE " + student);
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
		Student student = studentService.save(studentDTOtoStudent.convert(studentDTO));
			
		System.out.println("STUDENT JE" + student);
		return new ResponseEntity<>(studentToStudentDTO.convert(student), HttpStatus.CREATED);
			
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		Student student = studentService.findOne(studentDTO.getId());
		System.out.println("student JE " + student);
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		/*
		 * User user = userService.findOne(studentDTO.getUser().getId());
		 */		
	//	System.out.println("user je" + user.getId());
	//	System.out.println("studen bre ima usera kog " + student.getUser().toString());
	//	student.setUser(userDTOtoUser.convert(studentDTO.getUser()));
		student = studentService.save(studentDTOtoStudent.convert(studentDTO));
	//	System.out.println("AAALOO" + student.getUser().toString());
		return new ResponseEntity<>(studentToStudentDTO.convert(student), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Integer id){
		Student student = studentService.findOne(id);
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	
}

	

