package com.mamiyola.springdatajpawithmysqltutorial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
	@Id
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName =  "course_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence"
	)
	
	private Long courseId;
	private String title;
	private Integer credit;
	
	//defining BI-DIRECTIONAL 1 to 1 mapping(using mappedBy) 
	@OneToOne( //we are trying to reference CM from here(Course)b/c we are able to refer course from CM, but can't refer CM from course...b/c we are using UNIDIRECTIONAL-MAPPING
			mappedBy = "course" //course is the property defined in the CM class
	)
	//can't @JoinColumn here, b/c we already defined it in the course property
	private CourseMaterial courseMaterial;//property defined in Course class
	
	///@ManyToOne UNIDIRECTIONAL: JUST USING ONLY THIS IN Course doing nothing in the other side/////////////////
	@ManyToOne(
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherId"
	)
	private Teacher teacher;
	
	@ManyToMany(
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name = "student_course_map",
			joinColumns = @JoinColumn(
					name = "course_id",
					referencedColumnName = "courseId"
			),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentId"
			)
	)
	private List<Student> students;
	//when we are working with list we can create a method to add the particular list
	public void addStudents(Student student) {
		if(students == null) 
			students = new ArrayList<>();		
		students.add(student);
	}
}
