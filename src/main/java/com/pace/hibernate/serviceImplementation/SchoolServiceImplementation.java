package com.pace.hibernate.serviceImplementation;

import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.repository.SchoolRepository;
import com.pace.hibernate.response.Response;
import com.pace.hibernate.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImplementation implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public ResponseEntity<Response<School>> saveSchool(School school) {
        Response<School> response = new Response<>();
        response.setMessage("successfully saved");
        response.setHttpStatus(HttpStatus.CREATED.value());
        response.setData(schoolRepository.save(school));
        return new ResponseEntity<Response<School>>(response, HttpStatus.CREATED);
    }
    public ResponseEntity<Response<List<School>>> fetchAllSchools(){
        List<School> schools = schoolRepository.findAll();
        Response<List<School>> response = new Response<>();
        response.setMessage("Found");
        response.setHttpStatus(HttpStatus.CREATED.value());
        response.setData(schools);
        return new ResponseEntity<Response<List<School>>>(response, HttpStatus.CREATED);
    }
    public ResponseEntity<Response<School>> fetchSchoolById(int id){
        if(schoolRepository.findById(id).isPresent()){
            Response<School> response = new Response<>();
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(schoolRepository.findById(id).get());
            return new ResponseEntity<Response<School>>(response, HttpStatus.FOUND);
        }
        throw new StudentNotFoundException("School not found for given ID");
    }
    public ResponseEntity<Response<School>> fetchSchoolByName(String name){
        if (schoolRepository.findByName(name)!=null) {
            Response<School> response = new Response<>();
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(schoolRepository.findByName(name));
            return new ResponseEntity<Response<School>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("School not present for given Name");
        }

    }
    public ResponseEntity<Response<School>> deleteSchool(int id){
        if (schoolRepository.findById(id).isPresent()) {
            Response<School> response = new Response<>();
            School school = schoolRepository.findById(id).get();
            schoolRepository.delete(school);
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(school);
            return new ResponseEntity<Response<School>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("School not present for given Name");
        }
    }
    public ResponseEntity<Response<School>> updateSchool(School school){
        if(schoolRepository.findById(school.getId()).isPresent()){
            Response<School> response = new Response<>();
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(schoolRepository.save(school));
            return new ResponseEntity<Response<School>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("School does not exists to update");
        }
    }
}