package com.pace.hibernate.service;

import com.pace.hibernate.model.School;
import com.pace.hibernate.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    public School saveSchool(School school);

    public List<School> fetchAllSchools();

    public School fetchSchoolById(int id);

    public School fetchSchoolByName(String name);

    public School deleteSchool(int id);

    public School updateSchool(School school,int id);
}
