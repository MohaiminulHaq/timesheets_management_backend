package walton.springboot.service;
import org.springframework.data.domain.Page;
import walton.springboot.model.Employee;
import walton.springboot.model.Registration;

import java.util.List;

public interface RegistrationService {
	Registration saveEmployee(Registration employee);
	Registration updateEmployee(Registration employee);

	Registration delete(Registration employee);
	List<Registration> getAll();

//	List<Employee> getAllActive();

	Page<Registration> getPageableList(int page, int size);
}
