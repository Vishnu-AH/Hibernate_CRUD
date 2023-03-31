package com.pace.hibernate.service;

import com.pace.hibernate.model.School;

import java.util.List;

public interface SchoolService {

    public School saveSchool(School school);

    public List<School> fetchAllSchools();

    public School fetchSchoolById(int id);

    public School fetchSchoolByName(String name);

    public School deleteSchool(int id);

    public School updateSchool(School school);
}
