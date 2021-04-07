package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CreditCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CreditCard;

@Component
public class CreditCardToCreditCardDTO implements Converter<CreditCard, CreditCardDTO>{

	@Override
	public CreditCardDTO convert(CreditCard source) {
		if(source == null) {
			return null;
		}
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setId(source.getId());
		
		if(source.getCardNumber()!=null) {
			creditCardDTO.setCardNumber(source.getCardNumber());
		}
		if(source.getCvc()!=null) {
			creditCardDTO.setCvc(source.getCvc());
		}
		if(source.getName()!=null) {
			creditCardDTO.setName(source.getName());
		}
		if(source.getValid()!=null) {
			creditCardDTO.setValid(source.getValid());
		}
		
		
		return creditCardDTO;
	}
}