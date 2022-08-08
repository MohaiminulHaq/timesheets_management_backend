package walton.springboot.service;

import java.util.List;

import walton.springboot.model.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Employee updateEmployee(Employee employee);

	Employee delete(Employee employee);
	List<Employee> getAll();

//	List<Employee> getAllActive();

	Page<Employee> getPageableList(int page, int size);
}
