package com.challenge.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	@NotBlank(message = "Nome Obrigatório")
	@NotNull(message = "Nome Obrigatório")
	@Column
	private String name;
	
	@Email
	@NotBlank(message = "E-mail Obrigatório")
	@NotNull(message = "E-mail Obrigatório")
	@Column
	private String email;
	
	@NotBlank(message = "Telefone Obrigatório")
	@NotNull(message = "Telefone Obrigatório")
	@Column
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name = "code_person")
	private Person person;
	
	public Contact() {
		
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

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Contact(Long code,
				   String name,
			       String email,
			       String telephone,
			Person person) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.person = person;
	}

}
