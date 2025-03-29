package com.krushna.SpringBootYoutube2DataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krushna.SpringBootYoutube2DataJPA.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
