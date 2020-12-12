package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamPeriodDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;

@Component
public class EPeriodDTOtoEPeriod implements Converter<ExamPeriodDTO, ExamPeriod> {

	@Override
	public ExamPeriod convert(ExamPeriodDTO source) {
		if(source == null) {
			return null;
		}
		ExamPeriod examPeriod = new ExamPeriod();
		examPeriod.setId(source.getId());
		if(source.getName()!=null) {
			examPeriod.setName(source.getName());
		}
		if(source.getStartDate()!=null) {
			examPeriod.setStartDate(source.getStartDate());
		}
		if(source.getEndDate()!=null) {
			examPeriod.setEndDate(source.getEndDate());
		}
		return examPeriod;
	}

}
