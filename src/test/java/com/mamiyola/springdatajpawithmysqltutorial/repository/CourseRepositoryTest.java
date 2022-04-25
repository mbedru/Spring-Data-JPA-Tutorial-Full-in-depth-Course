package com.mamiyola.springdatajpawithmysqltutorial.repository;

import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mamiyola.springdatajpawithmysqltutorial.entity.Course;
import com.mamiyola.springdatajpawithmysqltutorial.entity.Student;
import com.mamiyola.springdatajpawithmysqltutorial.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		
		System.out.println("courses: " + courses);
	}	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("bruce")
				.lastName("mills")
				.build();
		
		Course course = Course.builder()
				.title("c++")
				.credit(5)
				.teacher(teacher)
				.build();
		
		courseRepository.save(course);
	}
	//PAGING
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
	
		List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		
		long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
		long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		
		System.out.println("totalPages = " + totalPages);
		System.out.println("totalElements = " + totalElements);
		System.out.println("courses = " + courses);
	}
	//PAGING WITH SORTING
	@Test
	public void findAllWithSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndPageableCreditDesc =
				PageRequest.of(0, 2, Sort.by("title").descending()
						.and(Sort.by("credit")));
		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		
		System.out.println("courses => " +courses);
	}
	//PAGING WITH SORTING USING CUSTOM METHOD(method defined in the JPARepository)
	@Test
	public void printfindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0,  10);
		
		List<Course> courses = courseRepository.findByTitleContaining("p",firstPageTenRecords);
		
		System.out.println("courses ==> " + courses );
	}
	//many to many b/n course & student
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("aisha")
				.lastName("usman")
				.build();
		
		Student student = Student.builder()
				.firstName("salih")
				.lastName("bedru")
				.emailId("salih18@yahoo.com")
				.build();
		
		Course course = Course.builder()
				.title("social-studies")
				.credit(3)
				.teacher(teacher)
				.build();
		
		course.addStudents(student);
		courseRepository.save(course);
	}
}










