package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepository;
	
	public Document findOne(Integer id) {
		return documentRepository.findById(id).orElse(null);
	}

	public List<Document> findAll() {
		return documentRepository.findAll();
	}
	
	public Page<Document> findAll(Pageable pageable) {
		return documentRepository.findAll(pageable);
	}

	public Document save(Document document) {
		return documentRepository.save(document);
	}

	public void remove(Integer id) {
		documentRepository.deleteById(id);
	}

	public Set<Document> findAllByStudentId(Integer id) {
		return documentRepository.findAllByStudentId(id);
	}
}
