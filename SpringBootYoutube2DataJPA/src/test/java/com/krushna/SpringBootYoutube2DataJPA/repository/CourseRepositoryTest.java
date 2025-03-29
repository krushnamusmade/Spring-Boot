package com.krushna.SpringBootYoutube2DataJPA.repository;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.krushna.SpringBootYoutube2DataJPA.entity.Course;
import com.krushna.SpringBootYoutube2DataJPA.entity.Student;
import com.krushna.SpringBootYoutube2DataJPA.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourse() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("Courses : "+courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Chetana")
				.lastName("Lungane")
				.build();
		
		Course course = Course.builder()
				.cousreName("AI")
				.credit(4)
				.teacher(teacher)
				.build();
		courseRepository.save(course);
	}
	
	@Test
	public void finaAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable SecondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = courseRepository.findAll(SecondPageWithTwoRecords).getContent();
		
		long totalElements = courseRepository.findAll(SecondPageWithTwoRecords).getTotalElements();
		
		long totalPages = courseRepository.findAll(SecondPageWithTwoRecords).getTotalPages();
		
		
		System.out.println("Toatal Pages : "+totalPages);
		System.out.println("Total Elements : "+totalElements);
		System.out.println("Course : "+courses);
		
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("cousreName"));
		Pageable sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 3, Sort.by("cousreName").descending().and(Sort.by("credit")));
		
		List<Course> coursesByTitle = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("Course : "+coursesByTitle);
		
		List<Course> coursesByCredit = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("Course credit : "+coursesByCredit);
		
		List<Course> coursesByTitleAndCredit = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("Course both : "+coursesByTitleAndCredit);
	}
	
	@Test
	public void printFindByTitleContaing() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = courseRepository.findByCousreNameContaining("J", firstPageTenRecords).getContent();
		System.out.println("Cousres  : " +courses);
		
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("Supriya")
				.lastName("Bhosale")
				.build();
		
		Student student = Student.builder()
				.firstName("Tejasvi")
				.lastName("Musmade")
				.emailId("tejasvi@gmail.com")
				.build();
		
		Course course = Course.builder()
				.cousreName("Java OOP's")
				.credit(5)
				.teacher(teacher)
				.build();
		
		course.addStudent(student);
		
		courseRepository.save(course);
	}
	
}
