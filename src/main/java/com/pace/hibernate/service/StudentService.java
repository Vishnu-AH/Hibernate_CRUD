package com.pace.hibernate.service;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student saveStudent(Student student, int school_id) throws SchoolNotFoundException;

    public List<Student> getStudents();

    public Student getStudentById(int id);

    public Student getStudentByName(String name);

    public Student deleteStudent(int id);

    public Student updateStudent(Student student, int id);

    public Optional<Student> findStudentByIdAndName(int id, String name);

    public Optional<Student> findByIdAndName(int id, String name);

}
