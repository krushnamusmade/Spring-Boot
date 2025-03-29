package com.krushna.SpringBootYoutube2DataJPA.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String cousreName;
	private Integer credit;
	
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial material;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "teacher_subid",
			referencedColumnName = "teacherId"
			)
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "course_student_map",
			joinColumns = @JoinColumn(
					name="course_id",
					referencedColumnName = "courseId"
					),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentId"
					)
			
			)
	private List<Student> students;
	
	public void addStudent(Student student) {
		if(students == null ) students = new ArrayList<Student>(); 
		students.add(student);
	}
}
