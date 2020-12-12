package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.ExamPeriodDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.ExamPeriod;

@Component
public class EPeriodToEPeriodDTO implements Converter<ExamPeriod, ExamPeriodDTO>{

	@Override
	public ExamPeriodDTO convert(ExamPeriod source) {
		if(source == null) {
			return null;
		}
		ExamPeriodDTO examPeriodDTO = new ExamPeriodDTO();
		examPeriodDTO.setId(source.getId());
		if(source.getName()!=null) {
			examPeriodDTO.setName(source.getName());
		}
		if(source.getStartDate()!=null) {
			examPeriodDTO.setStartDate(source.getStartDate());
		}
		if(source.getEndDate()!=null) {
			examPeriodDTO.setEndDate(source.getEndDate());
		}
		return examPeriodDTO;
	}

}
