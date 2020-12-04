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

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.UserService;

@RestController
@RequestMapping(value="api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudents(){
		List<Student> students = studentService.findAll();
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		for(Student student : students) {
			studentsDTO.add(new StudentDTO(student));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id){
		Student student = studentService.findOne(id);
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
		public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
			Student student = new Student();
		
			
			
			student = studentService.save(student);
			return new ResponseEntity<>(new StudentDTO(student), HttpStatus.CREATED);
		
			
	}
	
}

	

