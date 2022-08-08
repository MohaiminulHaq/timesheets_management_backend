package walton.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import walton.springboot.model.Employee;
import walton.springboot.model.Registration;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    //    List<Employee> findByActive(boolean active);
    String loginQuery = "SELECT * \n" +
            "FROM  registration a \n" +
            "WHERE  1=1\n" +
            "AND USER_NAME = :userName \n" +
            "and EMAIL = :email limit 1 \n";

    @Query(value = loginQuery, nativeQuery = true)
    Registration getLoginAuthentication(
            @Param("userName") String userName,
            @Param("email") String email);

}
