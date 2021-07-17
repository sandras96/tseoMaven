package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.PaymentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

@Component
public class PaymentToPaymentDTO implements Converter<Payment, PaymentDTO>{
	
	
	@Autowired
	FinancialCardToFinancialCardDTO financialCardToCFinancialCardDTO;
	
	@Autowired
	CreditCardToCreditCardDTO creditCardToCreditCardDTO;
	
	@Override
	public PaymentDTO convert(Payment source) {
		if(source == null) {
			return null;
		}
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setId(source.getId());
		
		if(source.getAmount()!=0) {
			paymentDTO.setAmount(source.getAmount());
		}
		if(source.getDate()!=null) {
			paymentDTO.setDate(source.getDate());
		}
		if(source.getName()!=null) {
			paymentDTO.setAccountName(source.getName());
		}
		if(source.getPurpose()!=null) {
			paymentDTO.setPurpose(source.getPurpose());
		}
		if(source.getFinancialCard()!=null) {
			paymentDTO.setFinancialCard(financialCardToCFinancialCardDTO.convert(source.getFinancialCard()));
		}
		if(source.getFinancialCard()!=null) {
			paymentDTO.setCreditCard(creditCardToCreditCardDTO.convert(source.getCreditCard()));
		}
		if(!source.isDeleted()) {
			paymentDTO.setDeleted(source.isDeleted());
		}
		
		return paymentDTO;
		
	}

}
