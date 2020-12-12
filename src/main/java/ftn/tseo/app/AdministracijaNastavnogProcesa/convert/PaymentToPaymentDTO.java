package ftn.tseo.app.AdministracijaNastavnogProcesa.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.PaymentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;

@Component
public class PaymentToPaymentDTO implements Converter<Payment, PaymentDTO>{

	@Autowired
	StudentToStudentDTO studentToStudentDTO;
	
	@Override
	public PaymentDTO convert(Payment source) {
		if(source == null) {
			return null;
		}
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setId(source.getId());
		if(source.getAccountNumber()!=null) {
			paymentDTO.setAccountNumber(source.getAccountNumber());
		}
		if(source.getAddress()!=null) {
			paymentDTO.setAddress(source.getAddress());
		}
		if(source.getAmount()!=0) {
			paymentDTO.setAmount(source.getAmount());
		}
		if(source.getCity()!=null) {
			paymentDTO.setCity(source.getCity());
		}
		if(source.getDate()!=null) {
			paymentDTO.setDate(source.getDate());
		}
		if(source.getModel()!=null) {
			paymentDTO.setModel(source.getModel());
		}
		if(source.getName()!=null) {
			paymentDTO.setName(source.getName());
		}
		if(source.getPaymentCode()!=null) {
			paymentDTO.setPaymentCode(source.getPaymentCode());
		}
		if(source.getPurpose()!=null) {
			paymentDTO.setPurpose(source.getPurpose());
		}
		if(source.getReference()!=null) {
			paymentDTO.setReference(source.getReference());
		}
		if(source.getStudent()!=null) {
			paymentDTO.setStudent(studentToStudentDTO.convert(source.getStudent()));
		}
		if(!source.isDeleted()) {
			paymentDTO.setDeleted(source.isDeleted());
		}
		
		return paymentDTO;
		
	}

}
