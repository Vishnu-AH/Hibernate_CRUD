package com.pace.hibernate.serviceImplementation;

import com.pace.hibernate.model.School;
import com.pace.hibernate.repository.SchoolRepository;
import com.pace.hibernate.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImplementation implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }
    public List<School> fetchAllSchools(){
        return schoolRepository.findAll();
    }
    public School fetchSchoolById(int id){
        return schoolRepository.findById(id).get();
    }
    public School fetchSchoolByName(String name){
        return schoolRepository.findByName(name);

    }
    public School deleteSchool(int id){
        School school = schoolRepository.findById(id).get();
        schoolRepository.delete(school);
        return school;
    }
    public School updateSchool(School school){
        School excistingSchool = schoolRepository.findById(school.getId()).get();
        if(excistingSchool!=null){
            return schoolRepository.save(school);
        }
        return null;
    }
}
