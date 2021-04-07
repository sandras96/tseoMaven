package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CreditCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CreditCard;

@Component
public class CreditCardDTOtoCreditCard implements Converter<CreditCardDTO, CreditCard>{

	@Override
	public CreditCard convert(CreditCardDTO source) {
		if(source == null) {
			return null;
		}
		CreditCard cc = new CreditCard();
		cc.setId(source.getId());
		if(source.getName()!=null) {
			cc.setName(source.getName());
		}
		if(source.getCardNumber()!=null) {
			cc.setCardNumber(source.getCardNumber());
		}
		if(source.getCvc()!=null) {
			cc.setCvc(source.getCvc());
		}
		if(source.getValid()!=null) {
			cc.setValid(source.getValid());
		}
		return cc;
	}


	

}
