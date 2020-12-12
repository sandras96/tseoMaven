package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.PaymentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

@Component
public class PaymentDTOtoPayment implements Converter<PaymentDTO, Payment>{

	@Autowired
	StudentDTOtoStudent studentDTOtoStudent;
	
	@Override
	public Payment convert(PaymentDTO source) {
		if(source == null) {
			return null;
		}
		Payment payment = new Payment();
		payment.setId(source.getId());
		if(source.getAccountNumber()!=null) {
			payment.setAccountNumber(source.getAccountNumber());
		}
		if(source.getAddress()!=null) {
			payment.setAddress(source.getAddress());
		}
		if(source.getAmount()!=0) {
			payment.setAmount(source.getAmount());
		}
		if(source.getCity()!=null) {
			payment.setCity(source.getCity());
		}
		if(source.getDate()!=null) {
			payment.setDate(source.getDate());
		}
		if(source.getModel()!=null) {
			payment.setModel(source.getModel());
		}
		if(source.getName()!=null) {
			payment.setName(source.getName());
		}
		if(source.getPaymentCode()!=null) {
			payment.setPaymentCode(source.getPaymentCode());
		}
		if(source.getPurpose()!=null) {
			payment.setPurpose(source.getPurpose());
		}
		if(source.getReference()!=null) {
			payment.setReference(source.getReference());
		}
		if(source.getStudent()!=null) {
			payment.setStudent(studentDTOtoStudent.convert(source.getStudent()));
		}
		if(!source.isDeleted()) {
			payment.setDeleted(source.isDeleted());
		}
		
		return payment;
		
	}

}
