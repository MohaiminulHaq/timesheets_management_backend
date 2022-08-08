package walton.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walton.springboot.model.LoginDto;
import walton.springboot.model.Registration;
import walton.springboot.repository.RegistrationRepository;
import walton.springboot.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    RegistrationRepository repository;

    @Override
    public Registration signIn(LoginDto loginDto) {
        Registration registration = repository.getLoginAuthentication(
                loginDto.getUserName(), loginDto.getEmail()
        );
        if (!registration.equals(null)) {
            return registration;
        } else {
            return null;
        }
    }
}
