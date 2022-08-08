package walton.springboot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import walton.springboot.controller.CommonUtils;
import walton.springboot.model.Employee;
import walton.springboot.model.Registration;
import walton.springboot.repository.RegistrationRepository;
import walton.springboot.service.RegistrationService;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationRepository registrationRepository;
	


	@Override
	public Registration saveEmployee(Registration employee) {
		return registrationRepository.save(employee);
	}

	@Override
	public Registration updateEmployee(Registration entity) {
		return registrationRepository.save(entity);
	}


	@Override
	public Registration delete(Registration employee) {
		registrationRepository.delete(employee);
		return employee;
	}

	@Override
	public List<Registration> getAll() {
		return registrationRepository.findAll();
	}



	@Override
	public Page<Registration> getPageableList(int page, int size) {
		PageRequest pageRequest = CommonUtils.getPageRequest(page, size);
		Page<Registration> pageResult = registrationRepository.findAll(pageRequest);
		List<Registration> objList = pageResult.stream()
				.collect(Collectors.toList());
		return new PageImpl<>(objList, pageRequest, pageResult.getTotalElements());
	}
	
}
