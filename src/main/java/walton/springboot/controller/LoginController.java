package walton.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import walton.springboot.constants.ApiConstants;
import walton.springboot.model.LoginDto;
import walton.springboot.model.Registration;
import walton.springboot.repository.RegistrationRepository;
import walton.springboot.service.LoginService;
import walton.springboot.service.RegistrationService;

import static walton.springboot.constants.MessageConstants.*;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginController {

    RegistrationRepository repository;

    LoginService loginService;


//    @PostMapping
//    public ResponseEntity<Registration> loginUser(@RequestBody Registration registrationData) {
//
//        Registration registration = repository.getById(registrationData.getId());
//        if (registration.getUserName().equals(registrationData.getUserName()))
//            return ResponseEntity.ok(registration);
//        return (ResponseEntity<Registration>) ResponseEntity.badRequest();
//    }


    @PostMapping()
    public Registration signIn(@RequestBody LoginDto loginDto) {
        return loginService.signIn(loginDto);
    }


}
