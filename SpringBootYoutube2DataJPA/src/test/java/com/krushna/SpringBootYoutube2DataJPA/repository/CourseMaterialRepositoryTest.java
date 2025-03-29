package com.krushna.SpringBootYoutube2DataJPA.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krushna.SpringBootYoutube2DataJPA.entity.Course;
import com.krushna.SpringBootYoutube2DataJPA.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
				.cousreName("C language")
				.credit(4)
				.build();
		
		CourseMaterial material = CourseMaterial.builder()
				.url("www.claguage.com")
				.course(course)
				.build();
		repository.save(material);
	}
	
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> cousrseMaterial = repository.findAll();
		System.out.println("Course : "+cousrseMaterial);
	}
}
