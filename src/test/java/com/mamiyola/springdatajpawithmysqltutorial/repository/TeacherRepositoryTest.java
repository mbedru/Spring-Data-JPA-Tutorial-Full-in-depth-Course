package com.mamiyola.springdatajpawithmysqltutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mamiyola.springdatajpawithmysqltutorial.entity.Course;
import com.mamiyola.springdatajpawithmysqltutorial.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDBA = Course.builder()
				.title("DBA")
				.credit(5)
				.build();
		
		Course courseMUSIC = Course.builder()
				.title("MUSIC")
				.credit(3)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("dereje")
				.lastName("dubale")
				//.courses(List.of(courseDBA, courseMUSIC))
				.build();
		
		teacherRepository.save(teacher);
	}

}
