package com.pace.hibernate.repository;

import com.pace.hibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByName(String name);
}
