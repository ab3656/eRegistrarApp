package edu.mum.cs.cs425.eregistrar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.eregistrar.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findStudentByFirstNameContaining(String characters);
}
