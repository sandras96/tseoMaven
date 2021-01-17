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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ProfessorDTOtoProfessor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.ProfessorToProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserDTOtoUser;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.UserToUserDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CourseDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamTakingDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ProfessorDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.StudentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Authority;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Course;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamTaking;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Professor;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.AuthorityRepository;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CourseService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ExamTakingService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.ProfessorService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.UserService;

@RestController
@RequestMapping(value="api/professors")
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamTakingService examTakingService;
	
	@Autowired
	ProfessorDTOtoProfessor professorDTOtoProfessor;
	
	@Autowired
	ProfessorToProfessorDTO professorToProfessorDTO;
	
	@Autowired
	UserDTOtoUser userDTOtoUser;

	@Autowired
	UserToUserDTO userToUserDTO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthorityRepository authorityRepository;
	

	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> getAllProfessors(){
		List<Professor> professors = professorService.findAll();
		List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
		for(Professor professor : professors) {
				System.out.println("professor je :" + professor.getFirstname());
				professorsDTO.add(new ProfessorDTO(professor));
		}
		System.out.println("lista je "+ professorsDTO.toString());
		return new ResponseEntity<>(professorsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Integer id){
		Professor professor = professorService.findOne(id);
		System.out.println("PROFESSOR JE " + professor);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ProfessorDTO(professor), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody ProfessorDTO professorDTO){
		Professor professor = new Professor();
		
		professor = professorDTOtoProfessor.convert(professorDTO);
		User user = new User();
		user.setUsername(professorDTO.getUser().getUsername());
		user.setPassword(passwordEncoder.encode(professorDTO.getUser().getPassword()));
		user.setDeleted(false);
		String string = "";
		Set<Authority> aa = new HashSet<>();
		for (Authority a : professorDTO.getUser().getAuthorities()) {
			string = a.getName();
			Authority b = authorityRepository.findByName(string);
			aa.add(b);
		}
		user.setUser_authorities(aa);
		
		userService.save(user);
		System.out.println("Authorities su " + user.getUser_authorities());
		
		professor.setUser(userService.findOne(user.getId()));
		professorService.save(professor);
		System.out.println("USER JE " + professor.getUser().getId());
		
			
		System.out.println("PROFESSOR JE" + professor);
		return new ResponseEntity<>(professorToProfessorDTO.convert(professor), HttpStatus.CREATED);
			
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value = "/{id}")
	public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO professorDTO, @PathVariable("id") Integer id ){
		Professor professor = professorService.findOne(id);
		System.out.println("Professor JE " + professor);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		professor = professorDTOtoProfessor.convert(professorDTO);
		
		User user = userService.findOne(professorDTO.getUser().getId());
		String string = "";
		Set<Authority> aa = new HashSet<>();
		for (Authority a : professorDTO.getUser().getAuthorities()) {
			string = a.getName();
			Authority b = authorityRepository.findByName(string);
			aa.add(b);
		}
		user.setUser_authorities(aa);
		
		professor.setUser(userDTOtoUser.convert(professorDTO.getUser()));
		professorService.save(professor);
		
		return new ResponseEntity<>(professorToProfessorDTO.convert(professor), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ProfessorDTO> deleteProfessor(@PathVariable Integer id){
		Professor professor = professorService.findOne(id);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
		//	User user = userService.findOne(professor.getUser().getId());
		//	user.setDeleted(true);
			System.out.println("PROFESSOR ZA BRISANJE JE " + professor.getPerson_id());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ProfessorDTO>> getProfessorsByCourseId(@PathVariable("id") Integer id){
		System.out.println("usao u listu profesora od kursa sa id: " + id);
	 	List<Professor> professors =professorService.getAllByCourseId(id);
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
            for (Professor professor : professors) {
            		professorsDTO.add(new ProfessorDTO(professor));
            }
         
        return new ResponseEntity<List<ProfessorDTO>>(professorsDTO,HttpStatus.OK);
    }
	
	@RequestMapping(value="/profcourse/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getCoursesByProfessor(@PathVariable("id") Integer id){
	 	List<Course> courses =courseService.getAllByProfessorId(id);
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
            for (Course course : courses) {
            		coursesDTO.add(new CourseDTO(course));
           }
         
        return new ResponseEntity<List<CourseDTO>>(coursesDTO,HttpStatus.OK);
    }
	
	@RequestMapping(value="/profcourse/{pId}/{cId}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseDTO> deleteCourseByProfessor(@PathVariable Integer pId, @PathVariable Integer cId){
		Course course = courseService.findOne(cId);
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			courseService.removeCourseProfessor(pId,cId);
			System.out.println("COURSE PROFESSOR ZA BRISANJE JE " + course.getName());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	@RequestMapping(value="/profExam/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ExamTakingDTO>> getExamsByProfessor(@PathVariable("id") Integer id){
	 	List<ExamTaking> examTakings =examTakingService.findAllByProfessorId(id);
        List<ExamTakingDTO> examTakingsDTO = new ArrayList<ExamTakingDTO>();
            for (ExamTaking et : examTakings) {
            	examTakingsDTO.add(new ExamTakingDTO(et));
           }
         
        return new ResponseEntity<List<ExamTakingDTO>>(examTakingsDTO,HttpStatus.OK);
    }
	
	@RequestMapping(value="user/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfessorDTO> getProfessorByUserId(@PathVariable Integer id){
		Professor professor = professorService.findByUserId(id);
		System.out.println("PROFESSOR JE " + professor);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ProfessorDTO(professor), HttpStatus.OK);
	}
}
