package com.example.demo.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "StudentTable")
@Entity
public class Student {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "StId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stid;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ -][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Surname")
	private String surname;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private Collection<Grade> grades;
	
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
