package com.pace.hibernate.repository;

import com.pace.hibernate.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
    School findByName(String name);
}
