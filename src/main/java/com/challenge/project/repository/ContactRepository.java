package com.challenge.project.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.challenge.project.model.Contact;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, String> {

	Contact findByCode(Long code);
	
	
	
}
