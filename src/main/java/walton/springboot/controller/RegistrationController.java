package walton.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import walton.springboot.constants.ApiConstants;
import walton.springboot.model.Employee;
import walton.springboot.model.Registration;
import walton.springboot.repository.EmployeeRepository;
import walton.springboot.repository.RegistrationRepository;
import walton.springboot.service.EmployeeService;
import walton.springboot.service.RegistrationService;

import static walton.springboot.constants.MessageConstants.*;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
	
	private RegistrationService registrationService;
	RegistrationRepository repository;


	@PostMapping()
	public CommonResponse save(@RequestBody Registration employee){
		try {
			return CommonUtils.generateSuccessResponse(registrationService.saveEmployee(employee), SAVE_MESSAGE, SAVE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
	@PutMapping
	public CommonResponse update(@RequestBody Registration employee){
		try {
			return CommonUtils.generateSuccessResponse(registrationService.updateEmployee(employee), UPDATE_MESSAGE, UPDATE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}


	@DeleteMapping
	public CommonResponse delete(@RequestBody Registration body){
		try {
			return CommonUtils.generateSuccessResponse(registrationService.delete(body), DELETE_MESSAGE, DELETE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}

	@GetMapping
	public CommonResponse getAll(){
		try {
			return CommonUtils.generateSuccessResponse(registrationService.getAll());
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}



	@GetMapping( value = ApiConstants.PAGEABLE_PATH, produces = ApiConstants.EXTERNAL_MEDIA_TYPE)
	public CommonResponse getPagableList(@PathVariable(ApiConstants.PAGEABLE_PAGE) int page, @PathVariable(ApiConstants.PAGEABLE_SIZE)int size){
		try {
			return CommonUtils.generateSuccessResponse(registrationService.getPageableList(page,size));
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<Registration> loginUser(@RequestBody Registration registrationData){

		  Registration registration =repository.getById(registrationData.getId());
		  if (registration.getUserName().equals(registrationData.getUserName()))
			  return ResponseEntity.ok(registration);
			  return (ResponseEntity<Registration>) ResponseEntity.badRequest();
	}


}
