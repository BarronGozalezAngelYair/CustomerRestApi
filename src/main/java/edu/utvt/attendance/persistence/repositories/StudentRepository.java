package edu.utvt.attendance.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
