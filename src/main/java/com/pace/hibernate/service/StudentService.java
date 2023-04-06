package com.pace.hibernate.service;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.Student;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StudentService {

    public Student saveStudent(Student student, int school_id) throws SchoolNotFoundException;

    public Page<Student> fetchAllStudents(int page,int pageSize, String sort, String order)throws StudentNotFoundException;

    public Optional<Student> getStudentById(int id)throws StudentNotFoundException;

    public Optional<Student> getStudentByName(String name)throws StudentNotFoundException;

    public Student deleteStudent(int id)throws StudentNotFoundException;

    public Student updateStudent(Student student, int id)throws StudentNotFoundException;

    public Optional<Student> findStudentByIdAndName(int id, String name)throws StudentNotFoundException;

    public Optional<Student> findByIdAndName(int id, String name)throws StudentNotFoundException;


}
