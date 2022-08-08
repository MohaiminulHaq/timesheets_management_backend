package walton.springboot.service;

import walton.springboot.model.LoginDto;
import walton.springboot.model.Registration;

public interface LoginService {
    Registration signIn(LoginDto loginDto);
}
