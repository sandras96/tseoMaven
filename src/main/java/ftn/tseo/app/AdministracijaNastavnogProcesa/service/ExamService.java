package ftn.tseo.app.AdministracijaNastavnogProcesa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.Exam;
import ftn.tseo.app.AdministracijaNastavnogProcesa.repository.ExamRepository;

@Service
public class ExamService {
	
	@Autowired
	ExamRepository examRepository;
	
	public Exam findOne(Integer id) {
		return examRepository.findById(id).orElse(null);
	}

	public List<Exam> findAll() {
		return examRepository.findAll();
	}
	
	public Page<Exam> findAll(Pageable pageable) {
		return examRepository.findAll(pageable);
	}

	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	public void remove(Integer id) {
		examRepository.deleteById(id);
	}

	public List<Exam> findAllByCourseId(Integer id){
		return examRepository.findAllByCourseId(id);
	}
	
	public List<Exam> findAllByExamPeriodId(Integer id){
		return examRepository.findAllByExamPeriodId(id);
	}
	
	public List<Exam> getAllByStudentId(Integer id){
		return examRepository.getAllByStudentId(id);
	}
	
	public List<Exam> findByExamPeriodName(String name){
		return examRepository.findByExamPeriodNameContaining(name);
	}
	public List<Exam> findByCourseName(String name){
		return examRepository.findByCourseNameContaining(name);
	}
	public List<Exam> findByExamPeriodNameAndCourse(String name, Integer id){
		return examRepository.findByExamPeriodNameContainingAndCourseId(name, id);
	}
	public List<Exam> findByCourseNameAndExamPeriod(String name, Integer id){
		return examRepository.findByCourseNameContainingAndExamPeriodId(name, id);
	}
}
