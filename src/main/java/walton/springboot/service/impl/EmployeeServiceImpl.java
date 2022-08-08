package walton.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import walton.springboot.controller.CommonUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import walton.springboot.model.Employee;
import walton.springboot.repository.EmployeeRepository;
import walton.springboot.service.EmployeeService;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee entity) {
		return employeeRepository.save(entity);
	}


	@Override
	public Employee delete(Employee employee) {
		employeeRepository.delete(employee);
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

//	@Override
//	public List<Employee> getAllActive() {
//		return employeeRepository.findByActive(true);
//	}

	@Override
	public Page<Employee> getPageableList(int page, int size) {
		PageRequest pageRequest = CommonUtils.getPageRequest(page, size);
		Page<Employee> pageResult = employeeRepository.findAll(pageRequest);
		List<Employee> objList = pageResult.stream()
				.collect(Collectors.toList());
		return new PageImpl<>(objList, pageRequest, pageResult.getTotalElements());
	}
	
}
