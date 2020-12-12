package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.DocumentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;

@Component
public class DocumentToDocumentDTO implements Converter<Document, DocumentDTO> {

	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@Override
	public DocumentDTO convert(Document source) {
		DocumentDTO documentDTO = new DocumentDTO();
		if(source == null) {
			return null;
		}
		documentDTO.setId(source.getId());
		if(source.getName()!=null) {
			documentDTO.setName(source.getName());
		}
		if(source.getDate()!=null) {
			documentDTO.setDate(source.getDate());
		}
		if(!source.isDeleted()) {
			documentDTO.setDeleted(source.isDeleted());
		}
		if(source.getStudent()!=null) {
			documentDTO.setStudent(studentToStudentDTO.convert(source.getStudent()));
		}
		
		return documentDTO;
	}

}
