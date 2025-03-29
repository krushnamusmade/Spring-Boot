package com.krushna.SpringBootYoutube2DataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krushna.SpringBootYoutube2DataJPA.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
