package com.challenge.project.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.challenge.project.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

	Person findByCode(Long code);
	
	
	
}
