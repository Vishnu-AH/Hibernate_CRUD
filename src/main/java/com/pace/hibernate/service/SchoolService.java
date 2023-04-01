package com.pace.hibernate.service;

import com.pace.hibernate.model.School;
import com.pace.hibernate.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolService {

    public ResponseEntity<Response<School>> saveSchool(School school);

    public ResponseEntity<Response<List<School>>> fetchAllSchools();

    public ResponseEntity<Response<School>> fetchSchoolById(int id);

    public ResponseEntity<Response<School>> fetchSchoolByName(String name);

    public ResponseEntity<Response<School>> deleteSchool(int id);

    public ResponseEntity<Response<School>> updateSchool(School school);
}
