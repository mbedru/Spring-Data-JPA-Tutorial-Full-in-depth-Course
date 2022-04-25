package com.mamiyola.springdatajpawithmysqltutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamiyola.springdatajpawithmysqltutorial.entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
