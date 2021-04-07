package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.CreditCardDTOtoCreditCard;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.FinancialCardDTOtoFinancialCard;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.PaymentDTOtoPayment;
import ftn.tseo.app.AdministracijaNastavnogProcesa.convert.PaymentToPaymentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.CreditCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.FinancialCardDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.dto.PaymentDTO;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.FinancialCardService;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.PaymentService;

@RestController
@RequestMapping(value="api/payments")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	FinancialCardService financialCardService;
	
	@Autowired
	PaymentDTOtoPayment paymentDTOtoPayment;
	
	@Autowired
	PaymentToPaymentDTO paymentToPaymentDTO;
	
	@Autowired
	FinancialCardDTOtoFinancialCard financialCardDTOtoFinancialCard;
	
	@Autowired
	CreditCardDTOtoCreditCard creditCardDTOtoCreditCard;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> getAllPayments(){
		List<Payment> payments = paymentService.findAll();
		List<PaymentDTO> paymentsDTO = new ArrayList<PaymentDTO>();
		for(Payment payment : payments) {
			paymentsDTO.add(new PaymentDTO(payment));
		}
		System.out.println("lista je "+paymentsDTO.toString());
		return new ResponseEntity<>(paymentsDTO, HttpStatus.OK);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Integer id){
		Payment payment = paymentService.findOne(id);
		System.out.println("PAYMENT JE " + payment);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO){
		System.out.println(paymentDTO.getFinancialCard().getBalance());
		FinancialCardDTO fc = paymentDTO.getFinancialCard();
		fc.setBalance(Double.sum(fc.getBalance(), paymentDTO.getAmount()));
		CreditCardDTO cc = paymentDTO.getCreditCard();
		Payment payment = paymentDTOtoPayment.convert(paymentDTO);
		payment.setFinancialCard(financialCardDTOtoFinancialCard.convert(fc));
		payment.setCreditCard(creditCardDTOtoCreditCard.convert(cc));
		financialCardService.save(financialCardDTOtoFinancialCard.convert(fc));
		paymentService.save(payment);
		
		System.out.println("PAY JE" + payment);
		return new ResponseEntity<>(paymentToPaymentDTO.convert(payment), HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO,@PathVariable("id") Integer id){
		Payment payment = paymentService.findOne(id);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		payment = paymentService.save(paymentDTOtoPayment.convert(paymentDTO));
		return new ResponseEntity<>(paymentToPaymentDTO.convert(payment), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<PaymentDTO> deletePayment(@PathVariable Integer id){
		Payment payment = paymentService.findOne(id);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			payment.setDeleted(true);
			paymentService.save(payment);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
//	@RequestMapping(value="/student/{id}", method= RequestMethod.GET)
//	public ResponseEntity<Set<PaymentDTO>> getPaymentByStudentId(@PathVariable Integer id){
//		Set<Payment> payments = paymentService.findAllByStudentId(id);
//		Set<PaymentDTO> paymentsDTO = new HashSet<PaymentDTO>();
//		for(Payment payment : payments) {
//			if(!payment.isDeleted()) {
//				paymentsDTO.add(new PaymentDTO(payment));
//			}
//			
//		}
//		System.out.println("lista je "+paymentsDTO.toString());
//		return new ResponseEntity<>(paymentsDTO, HttpStatus.OK);
//	}

	
}
