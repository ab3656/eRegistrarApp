package edu.mum.cs.cs425.eregistrar;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.impl.StudentServiceImpl;

@SpringBootApplication
public class ERegistrarAppApplication implements CommandLineRunner{

	@Autowired
	private StudentServiceImpl studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(ERegistrarAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("000-61-0001", "Anna", 
				"Mary", "Smith", 3.78f, LocalDate.of(2019, 5, 12), 
				"Yes");
		studentService.addStudent(student);
		
	}

}
