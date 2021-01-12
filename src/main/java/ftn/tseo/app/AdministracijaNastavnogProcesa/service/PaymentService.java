package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Document;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Payment;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment findOne(Integer id) {
		return paymentRepository.findById(id).orElse(null);
	}

	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}
	
	public Page<Payment> findAll(Pageable pageable) {
		return paymentRepository.findAll(pageable);
	}

	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	public void remove(Integer id) {
		paymentRepository.deleteById(id);
	}
	
	public Set<Payment> findAllByStudentId(Integer id) {
		return paymentRepository.findAllByStudentId(id);
	}

}
