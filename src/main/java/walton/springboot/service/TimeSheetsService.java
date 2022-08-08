package walton.springboot.service;



import org.springframework.data.domain.Page;
import walton.springboot.model.TimeSheets;

import java.util.List;

public interface TimeSheetsService {
	TimeSheets saveEmployee(TimeSheets timeSheets);
	TimeSheets updateEmployee(TimeSheets timeSheets);

	TimeSheets delete(TimeSheets timeSheets);
	List<TimeSheets> getAll();


	Page<TimeSheets> getPageableList(int page, int size);
}
