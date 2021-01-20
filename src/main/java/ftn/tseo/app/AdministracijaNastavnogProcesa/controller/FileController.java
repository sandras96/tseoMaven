package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.DocumentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FileDB;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.message.ResponseFile;
import ftn.tseo.app.AdministracijaNastavnogProcesa.message.ResponseMessage;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.FileStorageService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.StudentService;

@RestController
@RequestMapping(value="api/files")
public class FileController {
	
	 @Autowired
	 private FileStorageService storageService;
	 @Autowired
	 private StudentService studentService;
	 
	 @PostMapping("/upload/{studentId}")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("studentId") Integer studentId) {
	    String message = "";
	    try {
	    
	      Student student = studentService.findOne(studentId);
	      storageService.store(file, student);
	      System.out.println("fajl je " + file.getOriginalFilename() + "a student je "+ student.getFirstname());
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/files/student/{studentId}")
	  public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable("studentId")Integer studentId) {
	    List<ResponseFile> files = storageService.getAllFiles(studentId).map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("api/files/files/")
	          .path(dbFile.getId().toString())
	          .toUriString();

	      return new ResponseFile(
	    	  dbFile.getId(),
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getDate(),
	          dbFile.getData().length,
	          dbFile.getStudent().getPerson_id());
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
	    FileDB fileDB = storageService.getFile(id);
	    
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  
	  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<?> deleteFile(@PathVariable Integer id){
			FileDB fileDB = storageService.getFile(id);
			if(fileDB == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				storageService.remove(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
		}

}
