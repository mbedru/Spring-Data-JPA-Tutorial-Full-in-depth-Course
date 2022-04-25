package com.mamiyola.springdatajpawithmysqltutorial.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

	@Id
	@SequenceGenerator(
			name = "teacher_sequence",
			sequenceName = "teacher_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "teacher_sequence"
	)
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	//in the child property(list) found in the parent entity @onetomany 
	//blen join column kalen and child entity lay mnm @... mention kalaregn
	//it means:-- UNIDIRECTIONAL OneToMany:- @JoinColumn lay it sends the PK of parent entity to child as FK.
/*	@OneToMany(
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teachrId"
	)
	private List<Course> courses;
*/
}
