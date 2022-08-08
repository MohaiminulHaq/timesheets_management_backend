package walton.springboot.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import walton.springboot.constants.ApiConstants;
import walton.springboot.model.TimeSheets;
import walton.springboot.repository.TimeSheetsRepository;
import walton.springboot.service.TimeSheetsService;

import static walton.springboot.constants.MessageConstants.*;


@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/api/time-sheets")
public class TimeSheetsController {

	private TimeSheetsService timeSheetsService;
	TimeSheetsRepository repository;


	@PostMapping()
	public CommonResponse save(@RequestBody TimeSheets timeSheets){
		try {
			return CommonUtils.generateSuccessResponse(timeSheetsService.saveEmployee(timeSheets), SAVE_MESSAGE, SAVE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
	@PutMapping
	public CommonResponse update(@RequestBody TimeSheets timeSheets){
		try {
			return CommonUtils.generateSuccessResponse(timeSheetsService.updateEmployee(timeSheets), UPDATE_MESSAGE, UPDATE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}


	@DeleteMapping
	public CommonResponse delete(@RequestBody TimeSheets body){
		try {
			return CommonUtils.generateSuccessResponse(timeSheetsService.delete(body), DELETE_MESSAGE, DELETE_MESSAGE_BN);
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}

	@GetMapping
	public CommonResponse getAll(){
		try {
			return CommonUtils.generateSuccessResponse(timeSheetsService.getAll());
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}



	@GetMapping( value = ApiConstants.PAGEABLE_PATH, produces = ApiConstants.EXTERNAL_MEDIA_TYPE)
	public CommonResponse getPagableList(@PathVariable(ApiConstants.PAGEABLE_PAGE) int page, @PathVariable(ApiConstants.PAGEABLE_SIZE)int size){
		try {
			return CommonUtils.generateSuccessResponse(timeSheetsService.getPageableList(page,size));
		} catch (Exception e) {
			return CommonUtils.generateErrorResponse(e);
		}
	}
	
}
