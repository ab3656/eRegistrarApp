package edu.mum.cs.cs425.eregistrar.service;

import java.util.List;

import edu.mum.cs.cs425.eregistrar.model.Student;

public interface IStudentService {
	Student addStudent(Student student);
	List<Student> getStudents();
	Student getStudentFromStudentNumber(String studentNumber);
	void deleteStudent(Student student);
	List<Student> findStudent(String characters);
	Student modifyStudent(long id, Student student);
}
