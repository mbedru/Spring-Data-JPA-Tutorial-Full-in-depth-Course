package com.mamiyola.springdatajpawithmysqltutorial.entity;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
//
//import com.sun.tools.classfile.StackMapTable_attribute.full_frame;
//
//import ch.qos.logback.core.subst.Token.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")//ignoring course in the toString b/c couMaterial is not one object to convert it to string soo we ignore the course inside it.
					//...but we can make the fetchType.Eager inside onetoone annot of Course reference.
public class CourseMaterial {
	//CM sentera it shows only the CM(but not Course) b/c 1)fechType=LAZY slehone saytera course aymetam
			//2)toString lay exclude slaregnew
	@Id
	@SequenceGenerator(
			name = "course_material_sequence",
			sequenceName =  "course_material_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_material_sequence"
	)
	private Long CourseMaterialId;
	private String url;
	//course material will have Course b/c it cant exist without Course
	
	//creates a new fk column "course_id" in CourseMaterial w/c refer to the course it belong
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false
	)	
	//this is the owner of the relationship b/c it has the join column
	@JoinColumn(  //using which Column foreign key (from Course) will apply
			name = "course_id", //name of the new FK column
			referencedColumnName = "courseId" //column(of Course) which the FKin CM  is referencing to.
			)
	private Course course;
	
}
