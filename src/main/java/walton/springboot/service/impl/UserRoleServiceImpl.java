package walton.springboot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import walton.springboot.model.UserRole;
import walton.springboot.repository.UserRoleRepository;
import walton.springboot.service.UserRoleService;

import java.util.List;

@AllArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleRepository userRoleRepository;

	@Override
	public List<UserRole> getAll() {
		return userRoleRepository.findAll();
	}


	
}
