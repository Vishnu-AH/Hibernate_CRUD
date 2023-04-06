package com.pace.hibernate.service;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    public School saveSchool(School school);

    public Page<School> fetchAllSchools(int page,int pageSize, String sort, String order) throws SchoolNotFoundException;
    public School fetchSchoolById(int id)throws SchoolNotFoundException;

    public School fetchSchoolByName(String name)throws SchoolNotFoundException;

    public School deleteSchool(int id)throws SchoolNotFoundException;

    public School updateSchool(School school,int id)throws SchoolNotFoundException;


}
