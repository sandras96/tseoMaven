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

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.DocumentDTOtoDocument;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.DocumentToDocumentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.DocumentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.DocumentService;

@RestController
@RequestMapping(value="api/documents")
public class DocumentController {
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	DocumentDTOtoDocument documentDTOtoDocument;
	
	@Autowired
	DocumentToDocumentDTO documentToDocumentDTO;
	
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<DocumentDTO>> getAllDocuments(){
		List<Document> documents = documentService.findAll();
		List<DocumentDTO> documentsDTO = new ArrayList<DocumentDTO>();
		for(Document document : documents) {
			System.out.println("document je :" + document.getName());
			documentsDTO.add(new DocumentDTO(document));
		}
		System.out.println("lista je "+documentsDTO.toString());
		return new ResponseEntity<>(documentsDTO, HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Integer id){
		Document document = documentService.findOne(id);
		System.out.println("DOCUMENT JE " + document);
		if(document == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new DocumentDTO(document), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DocumentDTO> saveDocument(@RequestBody DocumentDTO documentDTO){
		Document document = documentService.save(documentDTOtoDocument.convert(documentDTO));
		
		System.out.println("DOC JE" + document);
		return new ResponseEntity<>(documentToDocumentDTO.convert(document), HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO documentDTO){
		Document document = documentService.findOne(documentDTO.getId());
		if(document == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		document = documentService.save(documentDTOtoDocument.convert(documentDTO));
		return new ResponseEntity<>(documentToDocumentDTO.convert(document), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<DocumentDTO> deleteDocument(@PathVariable Integer id){
		Document document = documentService.findOne(id);
		if(document == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			document.setDeleted(true);
			documentService.save(document);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	@RequestMapping(value="/student/{id}", method= RequestMethod.GET)
	public ResponseEntity<Set<DocumentDTO>> getDocumentByStudentId(@PathVariable Integer id){
		Set<Document> documents = documentService.findAllByStudentId(id);
		Set<DocumentDTO> documentsDTO = new HashSet<DocumentDTO>();
		for(Document document : documents) {
			System.out.println("document je :" + document.getName());
		 documentsDTO.add(new DocumentDTO(document));
		}
		System.out.println("lista je "+documentsDTO.toString());
		return new ResponseEntity<>(documentsDTO, HttpStatus.OK);
	}

	
}
