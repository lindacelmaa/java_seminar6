package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Entity
@Table(name = "GradeTable")
public class Grade {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "gId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gId;
	

	@Min(1)
	@Max(10)
	@Column(name = "value")
	private int value;
	
	
	@ManyToOne
	@JoinColumn(name = "StId")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "CId")
	private Course course;
	
	public Grade(int value, Student student, Course course) {
		setValue(value);
		setStudent(student);
		setCourse(course);
	}
}
