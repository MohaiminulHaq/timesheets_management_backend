package walton.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import walton.springboot.model.Registration;
import walton.springboot.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
//    List<Employee> findByActive(boolean active);

}
