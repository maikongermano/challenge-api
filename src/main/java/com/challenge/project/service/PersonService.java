package com.challenge.project.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.challenge.project.model.Person;
import com.challenge.project.repository.PersonRepository;
import com.challenge.project.utility.Utilities;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		if (!person.getCPF().isEmpty()) {
			String CPF = person.getCPF();
			if (Utilities.validarCPF(CPF) == false) {
				throw new RuntimeException("CPF inválido");
			}
		} else {
			throw new RuntimeException("CPF vazio");
		}

		if (person.getBirthDate().after(new Date())) {
			throw new RuntimeException("Data nascimento inválida");
		}

		if (person.getContacts().isEmpty()) {
			throw new RuntimeException("Nenhum contato informado");
		}

		person.getContacts().forEach(c -> {
			if (!c.getEmail().isEmpty()) {
				String email = c.getEmail();
				if (Utilities.isValidEmailAddressRegex(email) == false) {
					throw new RuntimeException("E-mail ínvalido");
				}
			} else {
				throw new RuntimeException("E-mail vazio");
			}

		});

		person.getContacts().forEach(p -> p.setPerson(person));
		return personRepository.save(person);
	}

	public Person updatePerson(Person person) {
		savePerson(person);
		return person;
	}

	public Person searchCode(Long code) {
		Person personSave = personRepository.findByCode(code);
		if (personSave == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return personSave;
	}

	public Page<Person> listPerson(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

}
