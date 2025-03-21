package lv.venta.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private long stId;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ -][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "surname")
	private String surname;
	
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
