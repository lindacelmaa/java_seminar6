package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ProfessorTable")
@Entity
public class Professor {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "PId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stId;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,10}([ -][A-Z]{1}[a-z]{3,10})?")
	@Column(name = "Surname")
	private String surname;
	
	@NotNull
	@Column(name = "Title")
	private Degree degree;
	
	@ToString.Exclude
	@OneToOne(mappedBy = "professor")
	private Course course;
	
	public Professor(String name, String surname, Degree degree) {
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
}
