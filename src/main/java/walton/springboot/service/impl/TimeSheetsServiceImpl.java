package walton.springboot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import walton.springboot.controller.CommonUtils;
import walton.springboot.model.TimeSheets;
import walton.springboot.repository.TimeSheetsRepository;
import walton.springboot.service.TimeSheetsService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TimeSheetsServiceImpl implements TimeSheetsService {

	private TimeSheetsRepository timeSheetsRepository;
	


	@Override
	public TimeSheets saveEmployee(TimeSheets timeSheets) {
		return timeSheetsRepository.save(timeSheets);
	}

	@Override
	public TimeSheets updateEmployee(TimeSheets entity) {
		return timeSheetsRepository.save(entity);
	}


	@Override
	public TimeSheets delete(TimeSheets timeSheets) {
		timeSheetsRepository.delete(timeSheets);
		return timeSheets;
	}

	@Override
	public List<TimeSheets> getAll() {
		return timeSheetsRepository.findAll();
	}



	@Override
	public Page<TimeSheets> getPageableList(int page, int size) {
		PageRequest pageRequest = CommonUtils.getPageRequest(page, size);
		Page<TimeSheets> pageResult = timeSheetsRepository.findAll(pageRequest);
		List<TimeSheets> objList = pageResult.stream()
				.collect(Collectors.toList());
		return new PageImpl<>(objList, pageRequest, pageResult.getTotalElements());
	}
	
}
