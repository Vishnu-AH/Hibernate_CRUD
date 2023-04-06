package com.pace.hibernate.serviceImplementation;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.repository.SchoolRepository;
import com.pace.hibernate.repository.StudentRepository;
import com.pace.hibernate.service.StudentService;
import com.pace.hibernate.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Student> fetchAllStudents(int page,int pageSize, String sort, String order) throws StudentNotFoundException{
        Pageable pageable = CommonUtil.getPageable(page,pageSize,sort,order);
        return studentRepository.findAll(pageable);
    }
    @Override
    public Optional<Student> getStudentById(int id) throws StudentNotFoundException{
        return studentRepository.findById(id);
    }
    @Override
    public Optional<Student> getStudentByName(String name) throws StudentNotFoundException{
        return studentRepository.findByName(name);
    }

    @Override
    public Student deleteStudent(int id) throws StudentNotFoundException{
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
    public Student updateStudent(Student student,int id) throws StudentNotFoundException{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            student.setId(id);
            student.setSchool(optionalStudent.get().getSchool());
            return studentRepository.save(student);
        }else{
            throw new StudentNotFoundException("Student does not exists to update");
        }
    }

    @Override //JPQL Query
    public Optional<Student> findStudentByIdAndName(int id, String name) throws StudentNotFoundException{
        Optional<Student> optionalStudent = studentRepository.findStudentByIdAndName(id, name);
        if(optionalStudent.isPresent()){
            return optionalStudent;
        }else{
            throw new StudentNotFoundException("Student not found for given ID and Name");
        }
    }

    @Override //Native Query
    public Optional<Student> findByIdAndName(int id, String name) throws StudentNotFoundException{
        Optional<Student> optionalStudent = studentRepository.findByIdAndName(id, name);
        if(optionalStudent.isPresent()){
            return optionalStudent;
        }else{
            throw new StudentNotFoundException("Student not found for given ID and Name");
        }
    }


}
