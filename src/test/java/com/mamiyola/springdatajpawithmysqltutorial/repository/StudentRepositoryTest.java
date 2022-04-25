package com.mamiyola.springdatajpawithmysqltutorial.repository;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.mamiyola.springdatajpawithmysqltutorial.entity.Guardian;
import com.mamiyola.springdatajpawithmysqltutorial.entity.Student;
//import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

@SpringBootTest
//we could use @DataJpaTest for repo testing b/c it flushes db(real db not impacted) after test but we want to see the effects , so no flushing . so we going with the standard testing  @SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("khebib@gmail.com")
				.firstName("khebib")
				.lastName("normagedov")
				//.guardianName("sembady")
				//.guardianEmail("sembady@yahoo.com")
				//.guardianMobile("0912999730")
				.build();
	
		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.name("newsembady")
				.email("newsembady@yahoo.com")
				.mobile("new0912999735")
				.build();
		
		Student student = Student.builder()
				.firstName("newsalih")
				.lastName("newbedru")
				.emailId("newsalih@yahoo.com")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void printStudentsByName() {
		List<Student> stud = studentRepository.findByFirstName("newsalih");
		System.out.println("stud-found: "+ stud);
	}
	@Test
	public void printStudentsByNameContaining() {
		List<Student> stud = studentRepository.findByFirstNameContaining("news");
		System.out.println("stud-found: "+ stud);
	}
	@Test
	public void printStudentsByLastNameNotNull() {
		List<Student> students = studentRepository.findByLastNameNotNull();
		System.out.println("students by last name not null:" + students );

	}
	@Test
	public void printStudentByGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("sembady");
		System.out.println("stud found by guardian name: " + students);
	}
	@Test
	public void printStudentByFirstNameAndLastName() {
		List<Student> students = studentRepository.findByFirstNameAndLastName("newsalih", "newbedru");
		System.out.println("stud found by fn & ln: " + students);
	}
	
	@Test
	public void printStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("newsalih@yahoo.com");
		System.out.println("stud found by emailId: " + student);
	}
	
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String studFn = studentRepository.getStudentFirstNameByEmailAddress("newsalih@yahoo.com");
		System.out.println("first name of stud found by emailId: " + studFn);
	}
	
	@Test
	public void printStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("newsalih@yahoo.com");
		System.out.println("[USING-NATIVE-QUERY]first name of stud found by emailId: " + student);
	}

	@Test
	public void printStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("newsalih@yahoo.com");
		System.out.println("[USING-NATIVE-QUERY && NAMED-PARAM]first name of stud found by emailId: " + student);
	}
	
	@Test 
	public void printAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("studentList: " + studentList);
	}
	
	@Test
	public void updateStudentNameByEmailId() {
		studentRepository.updateStudentNameByEmailId("newmame", "mame@gmail.com");
	}

}
