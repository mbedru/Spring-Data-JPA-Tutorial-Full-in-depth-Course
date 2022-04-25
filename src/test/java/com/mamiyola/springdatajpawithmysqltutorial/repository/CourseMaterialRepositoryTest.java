package com.mamiyola.springdatajpawithmysqltutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mamiyola.springdatajpawithmysqltutorial.entity.Course;
import com.mamiyola.springdatajpawithmysqltutorial.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;

	@Test
	public void SaveCourseMaterial() {
		Course course = Course.builder()
				.title("DSA")
				.credit(5)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.fb.com")
				.course(course)
				.build();

		
		repository.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterial = repository.findAll();
		System.out.println("list of courseMaterials: " + courseMaterial);
	}

}
