package ftn.tseo.app.AdministracijaNastavnogProcesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.CourseAttendance;

public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, Integer>{

}
