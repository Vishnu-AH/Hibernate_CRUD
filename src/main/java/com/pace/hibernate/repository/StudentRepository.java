package com.pace.hibernate.repository;

import com.pace.hibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByName(String name);
}
