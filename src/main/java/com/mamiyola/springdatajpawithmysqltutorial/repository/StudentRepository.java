package com.mamiyola.springdatajpawithmysqltutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mamiyola.springdatajpawithmysqltutorial.entity.Student;

import net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String name);
	public List<Student> findByLastNameNotNull();
	public List<Student> findByGuardianName(String guardianName);
	public List<Student> findByFirstNameAndLastName(String fn, String ln);
	
	//these queries are based on the Entity/Class (Student for now), not the tables in the mysql-db
	//JPQL
	@Query("select s from Student s where s.emailId = ?1")
	public Student  getStudentByEmailAddress(String emailId);
	
	//JPQL
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String  getStudentFirstNameByEmailAddress(String emailId);
	
	//when we have complex Object/Query that we can't define from JPA/JPQL
	//SOO spring-data-jpa also gives us support for Native Queries as well.
	//Native
	@Query(
			value="select * from tbl_student s where s.email_address = ?1",
			nativeQuery = true
	)
	public Student getStudentByEmailAddressNative(String emailId);
	
	//instead of passing as ?1 , ?2 ...
	//Native-Named-Params
	@Query(
			value= "select * from tbl_student s where s.email_address = :emailId",
			nativeQuery = true
	)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

	//updating function
	
	@Modifying //INSERT UPDATE DELETE & DDL sttmts must have this annot  
	@Transactional //1.transaction created 2.transactin made(ins, upd,del) 3.transaction comitted to database//@Trans Can be specified in the (repository/service ) OR method level
	@Query(
			value = "update tbl_student set first_name = ?1 where email_address = ?2",
			nativeQuery = true
	)	
	int updateStudentNameByEmailId(String firstName, String emailId);
	
	//JPA Relationships
	//OneToOne
	
}
