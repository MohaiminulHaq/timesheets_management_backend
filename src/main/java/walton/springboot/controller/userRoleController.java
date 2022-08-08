package walton.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import walton.springboot.service.UserRoleService;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/api/userrole")
public class userRoleController {
	
	private UserRoleService service;

	@GetMapping
	public CommonResponse getAll2(){
		try {
			return CommonUtils.generateSuccessResponse(service.getAll());
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}

	
}
