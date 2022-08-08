package walton.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="registration")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	
	@Column(name = "EMP_ID")
	private int empId;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "PAY_RATE")
	private String payRate;

	@Column(name = "SALARY")
	private String salary;

	@Column(name = "PAY_CAP")
	private String payCap;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "EMAIL")
	private String email;

	@ManyToOne
	@JoinColumn(name = "USER_ROLE_ID")
	private UserRole userRole;

}
