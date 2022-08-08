package walton.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="time_sheets")
public class TimeSheets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "emp_Type")
	private String empType;
	
	@Column(name = "start_work")
	private String startWork;
	
	@Column(name = "finish_work")
	private String finishWork;

	@Column(name = "effective_work_hours")
	private String effectiveWorkHours;

	@Column(name = "per_day_work")
	private String perDayWork;

	@Column(name = "per_emp_work")
	private String perEmpWork;

	@Column(name = "par_time_salary")
	private String partTimeSalary;

	@Column(name = "submit")
	private boolean submit;

	@Column(name = "approve")
	private boolean approve;



}
