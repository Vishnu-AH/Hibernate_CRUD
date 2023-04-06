package com.pace.hibernate.serviceImplementation;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.repository.SchoolRepository;
import com.pace.hibernate.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImplementation implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }
    @Override
    public List<School> fetchAllSchools(){
        return schoolRepository.findAll();
    }
    @Override
    public School fetchSchoolById(int id){
        return schoolRepository.findById(id).orElseThrow(()->new SchoolNotFoundException("School not found for given ID"));
    }
    @Override
    public School fetchSchoolByName(String name){
        return schoolRepository.findByName(name).orElseThrow(()->new SchoolNotFoundException("School not present for given Name"));
    }
    @Override
    public School deleteSchool(int id){
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isPresent()) {
            School school = optionalSchool.get();
            schoolRepository.delete(school);
            return school;
        }else{
            throw new SchoolNotFoundException("School not present for given Name");
        }
    }
    @Override
    public School updateSchool(School school,int id){
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if(optionalSchool.isPresent()){
            school.setId(id);
            return schoolRepository.save(school);
        }else{
            throw new SchoolNotFoundException("School does not exists to update");
        }
    }
}