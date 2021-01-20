package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.FileDB;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Student;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.FileDBRepository;

@Service
public class FileStorageService {
	
	  @Autowired
	  private FileDBRepository fileDBRepository;
	  
	//receives MultipartFile object, transform to FileDB object and save it to Database
	  public FileDB store(MultipartFile file, Student student) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  
		    Date date = new Date();
		    FileDB FileDB = new FileDB(fileName, file.getContentType(), date, file.getBytes(), student);
		  
		    return fileDBRepository.save(FileDB);
		  }

		  public FileDB getFile(Integer id) {
		    return fileDBRepository.findById(id).get();
		  }
		  
		  public Stream<FileDB> getAllFiles(Integer id) {
		    return fileDBRepository.findAllByStudentId(id).stream();
		  }
		  
		  public void remove(Integer id) {
			  fileDBRepository.deleteById(id);
			}

}
