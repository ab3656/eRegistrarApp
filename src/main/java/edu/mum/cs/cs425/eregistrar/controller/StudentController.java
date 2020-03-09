package edu.mum.cs.cs425.eregistrar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.impl.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping(value = "/students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping(value = "/students/{studentNumber}")
	public Student getStudent(@PathVariable String studentNumber){
		return studentService.getStudentFromStudentNumber(studentNumber);
	}

	@GetMapping(value = "/students/search")
	public List<Student> getStudentFilter(@RequestParam(value = "value") String val){
		return studentService.findStudent(val);
	}
	
	@PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	
	@PutMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student modifyStudent(@PathVariable(value="id") long id, @RequestBody Student student){
		return studentService.modifyStudent(id, student);
	}
	
	@DeleteMapping(value = "/students/{id}")
	public void deleteStudent(@PathVariable long id){
		studentService.deleteStudent(studentService.getStudent(id));
	}

}
