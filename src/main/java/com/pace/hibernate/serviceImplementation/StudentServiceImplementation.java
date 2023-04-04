package com.pace.hibernate.serviceImplementation;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.repository.SchoolRepository;
import com.pace.hibernate.repository.StudentRepository;
import com.pace.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public Student saveStudent(Student student, int school_id) throws SchoolNotFoundException {
        Optional<School> optionalSchool = schoolRepository.findById(school_id);
        if(optionalSchool.isPresent()){
            student.setSchool(optionalSchool.get());
            return studentRepository.save(student);
        }else{
            throw new SchoolNotFoundException("School does not exist for given ID");
        }
    }
    @Override
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    @Override
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not present for given ID"));
    }
    @Override
    public Student getStudentByName(String name){
        return studentRepository.findByName(name).orElseThrow(()-> new StudentNotFoundException("Student not present for given Name"));
    }
    @Override
    public Student deleteStudent(int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
            return student;
        }else{
            throw new StudentNotFoundException("Student not present for given Name");
        }
    }
    @Override
    public Student updateStudent(Student student,int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            student.setId(id);
            student.setSchool(optionalStudent.get().getSchool());
            return studentRepository.save(student);
        }else{
            throw new StudentNotFoundException("Student does not exists to update");
        }
    }

    @Override
    public Optional<Student> findStudentByIdAndName(int id, String name) {
        return studentRepository.findStudentByIdAndName(id,name);
    }

    @Override
    public Optional<Student> findByIdAndName(int id, String name) {
        return studentRepository.findByIdAndName(id,name);
    }


}
