package com.challenge.project.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long code;
	
	@NotBlank(message = "Nome é Obrigatório")
	@NotNull(message = "Nome Obrigatório")
	@Column
	private String name;
	
	@NotBlank(message = "CPF Obrigatório")
	@NotNull(message = "CPF Obrigatório")
	@Column
	private String cpf;
	
	@NotBlank(message = "Data de Nascimento Obrigatório")
	@NotNull(message = "Data de Nascimento Obrigatório")
	@Column
	private Date birthDate;
	
	@JsonIgnoreProperties("person")
	@Valid
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Contact> contacts;
	
	
	
	public Person() {
		
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}
	
	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Person(Long code,
				  String name,
				  String cpf,
				  Date birthDate,
			List<Contact> contacts) {
		this.code = code;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.contacts = contacts;
	}

}
