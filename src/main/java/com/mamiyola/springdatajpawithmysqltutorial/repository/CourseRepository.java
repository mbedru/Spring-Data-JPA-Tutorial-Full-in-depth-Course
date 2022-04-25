package com.mamiyola.springdatajpawithmysqltutorial.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mamiyola.springdatajpawithmysqltutorial.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	//custom method for sorting
	List<Course> findByTitleContaining(String title, Pageable pageable);
}
