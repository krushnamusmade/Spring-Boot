package com.krushna.SpringBootYoutube2DataJPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {

	@Id
	@SequenceGenerator( name = "student_sequence",
						sequenceName = "student_sequence",
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "student_sequence")
	private long studentId;
	private String firstName;
	private String lastName;
	@Column(nullable = false, unique = true)
	private String emailId;
	
	@Embedded
	private Guardian guardian;
	
	
}
