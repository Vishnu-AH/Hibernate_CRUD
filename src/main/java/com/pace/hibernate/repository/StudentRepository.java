package com.pace.hibernate.repository;

import com.pace.hibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.id = :id and s.name = :name")
    public Optional<Student> findStudentByIdAndName(int id, String name);

    @Query(value = "select * from students where id=?1 and name=?2",nativeQuery = true)
    public Optional<Student> findByIdAndName(int id,String name);
    
}
