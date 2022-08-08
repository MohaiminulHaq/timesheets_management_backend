package walton.springboot.controller;
import lombok.AllArgsConstructor;
import walton.springboot.constants.ApiConstants;
import walton.springboot.model.Employee;
import walton.springboot.repository.EmployeeRepository;
import walton.springboot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import static walton.springboot.constants.MessageConstants.*;


@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	EmployeeRepository  repository;


	@PostMapping()
	public CommonResponse save(@RequestBody Employee employee){
		try {
			return CommonUtils.generateSuccessResponse(employeeService.saveEmployee(employee), SAVE_MESSAGE, SAVE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
	@PutMapping
	public CommonResponse update(@RequestBody Employee employee){
		try {
			return CommonUtils.generateSuccessResponse(employeeService.updateEmployee(employee), UPDATE_MESSAGE, UPDATE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}


	@DeleteMapping
	public CommonResponse delete(@RequestBody Employee body){
		try {
			return CommonUtils.generateSuccessResponse(employeeService.delete(body), DELETE_MESSAGE, DELETE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}

	@GetMapping
	public CommonResponse getAll(){
		try {
			return CommonUtils.generateSuccessResponse(employeeService.getAll());
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
//	@GetMapping
//	public List<Employee> getAllEmployees(){
//		return repository.findAll();
//	}

//	@GetMapping( value = ACTIVE_PATH, produces = EXTERNAL_MEDIA_TYPE)
//	public CommonResponse getAllActive(){
//		try {
//			return CommonUtils.generateSuccessResponse(employeeService.getAllActive());
//		} catch (Exception e) {
//			return CommonUtils.generateErrorResponse(e);
//		}
//	}


	@GetMapping( value = ApiConstants.PAGEABLE_PATH, produces = ApiConstants.EXTERNAL_MEDIA_TYPE)
	public CommonResponse getPagableList(@PathVariable(ApiConstants.PAGEABLE_PAGE) int page, @PathVariable(ApiConstants.PAGEABLE_SIZE)int size){
		try {
			return CommonUtils.generateSuccessResponse(employeeService.getPageableList(page,size));
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
	
}
