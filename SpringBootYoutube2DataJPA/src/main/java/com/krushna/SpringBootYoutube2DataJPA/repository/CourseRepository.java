package com.krushna.SpringBootYoutube2DataJPA.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krushna.SpringBootYoutube2DataJPA.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	Page<Course> findByCousreNameContaining(String courseName,Pageable pageRequest);

}
