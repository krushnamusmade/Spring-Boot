package com.krushna.SpringBootYoutube2DataJPA.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krushna.SpringBootYoutube2DataJPA.entity.Guardian;
import com.krushna.SpringBootYoutube2DataJPA.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		
		Student student = Student.builder()
				.emailId("krushnamusmade90@gmail.com")
				.firstName("krushna")
				.lastName("musmade")
//				.guardianName("bharati")
//				.guardianMobile("123456789")
//				.guardianEmail("bharat@gmail.com")
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.email("bharat@gmail.com")
				.name("bharati")
				.mobile("123456789")
				.build();
		
		Student student = Student.builder()
				.firstName("kiran")
				.lastName("musmade")
				.emailId("kiran@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void getAllStudent() {
		List<Student> studentsList = studentRepository.findAll();
		
		System.out.println("Student List = "+studentsList);
	}

	@Test
	public void printStudentByFirstName() {
		List<Student> student = studentRepository.findByFirstName("kiran");
		System.out.println("Student + "+student);
	}
	
	@Test
	public void printStudentNameContaing() {
		List<Student> student = studentRepository.findByFirstNameContaining("k");
		System.out.println("Student : "+student);
	}
	
	@Test
	public void printNameBasedOnGuardianName() {
		List<Student> student = studentRepository.findByGuardianName("bharati");
		System.out.println("Student : "+student);
	}
	
	@Test
	public void printStudentByEmailId() {
		Student student = studentRepository.getStudentByEmailId("krushnamusmade90@gmail.com");
		System.out.println("Student : "+student);
	}
	
	@Test
	public void printStudentFirstNameByEmailId() {
		String student = studentRepository.getstudentFirstNameByEmailId("kiran@gmail.com");
		System.out.println("Student First Name : "+student);
	}
	
	@Test
	public void printStudentInfromationByNativeQuery() {
		Student student = studentRepository.getStudentInformationByNativeQuery("krushnamusmade90@gmail.com");
		System.out.println("Student : "+student);
	}
	
	@Test
	public void printStudentInfromationByNativeQueryParam() {
		Student student = studentRepository.getStudentInformationByNativeQueryParam("kiran@gmail.com");
		System.out.println("Student Infromation : "+student);
	}
	
	@Test
	public void updateFirstNameByUsingEmailIdTest() {
		studentRepository.updateFirstNameByUsingEmailId("krushna musmade", "krushnamusmade90@gmail.com");
	}
	
}
