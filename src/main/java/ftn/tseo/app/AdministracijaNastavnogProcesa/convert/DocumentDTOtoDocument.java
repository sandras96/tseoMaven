package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.DocumentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;

@Component
public class DocumentDTOtoDocument implements Converter<DocumentDTO, Document> {

	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;
	
	@Override
	public Document convert(DocumentDTO source) {
		Document document = new Document();
		if(source == null) {
			return null;
		}
		document.setId(source.getId());
		if(source.getName()!=null) {
			document.setName(source.getName());
		}
		if(source.getDate()!=null) {
			document.setDate(source.getDate());
		}
		if(!source.isDeleted()) {
			document.setDeleted(source.isDeleted());
		}
		if(source.getStudent()!=null) {
			document.setStudent(studentDTOtoStudent.convert(source.getStudent()));
		}
		
		return document;
	}

	public Set<Document> convert(Set<DocumentDTO> source){
		Set<Document> d = new HashSet<Document>();
		for(DocumentDTO dd : source){
			d.add(convert(dd));
		}
		
		return d;
	}
}
