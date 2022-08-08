package walton.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user_role")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	
	@Column(name = "role_Type")
	private String roleType;


}
