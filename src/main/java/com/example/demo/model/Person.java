package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PersonTable")
@Entity
public class Person {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "PeId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long peid;
	
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ -][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Surname")
	private String surname;
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
