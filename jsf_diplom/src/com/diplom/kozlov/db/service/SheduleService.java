package com.diplom.kozlov.db.service;

import java.util.List;

import com.diplom.kozlov.db.dto.SheduleDto;



public interface SheduleService {
	void save(SheduleDto sheduleDto);
	List<SheduleDto> getShedule();

}
