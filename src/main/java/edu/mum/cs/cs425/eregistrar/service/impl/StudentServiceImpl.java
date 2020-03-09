package edu.mum.cs.cs425.eregistrar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.eregistrar.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentFromStudentNumber(String studentNumber) {
		return studentRepository.findAll().stream()
				.filter(s -> s.getStudentNumber().equals(studentNumber))
				.findFirst().get();
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}

	@Override
	public List<Student> findStudent(String characters) {
		return studentRepository.findStudentByFirstNameContaining(characters);
	}

	@Override
	public Student modifyStudent(long id, Student student) {
		return studentRepository.findById(id)
				.map(s -> {
					s.setStudentNumber(student.getStudentNumber());
					s.setFirstName(student.getFirstName());
					s.setMiddleName(student.getMiddleName());
					s.setLastName(student.getLastName());
					s.setCgpa(student.getCgpa());
					s.setEnrollmentDate(student.getEnrollmentDate());
					s.setIsInternational(student.getIsInternational());
					return studentRepository.save(s);
				}).orElseGet(() -> {
					return studentRepository.save(student);
				});
	}

	public Student getStudent(long id) {
		return studentRepository.getOne(id);
	}

}
