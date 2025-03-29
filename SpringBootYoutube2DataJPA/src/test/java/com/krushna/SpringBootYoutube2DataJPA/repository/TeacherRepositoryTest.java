package com.krushna.SpringBootYoutube2DataJPA.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krushna.SpringBootYoutube2DataJPA.entity.Course;
import com.krushna.SpringBootYoutube2DataJPA.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDSA = Course.builder()
				.cousreName("DSA - I")
				.credit(4)
				.build();
		Course courseUHVE = Course.builder()
				.cousreName("Universal Human Values Ethics")
				.credit(2)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Bhayashree")
				.lastName("Kotame")
				//.courses(List.of(courseDSA,courseUHVE))
				.build();
		
		teacherRepository.save(teacher);
				
	}
	

}
