package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dao.SheduleDao;
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.entity.SheduleEntity;

public class SheduleServiceImpl implements SheduleService {

	private SheduleDao sheduleDao = new SheduleDao();
	
	private Mapper mapper = new Mapper();
	@Override
	public void save(SheduleDto sheduleDto) {
		
	
	}

	@Override
	public List<SheduleDto> getShedule() {
		List<SheduleEntity> sheduleEntity = sheduleDao.getShedule();
		List<SheduleDto> sheduleDto = new ArrayList<>();
		for(SheduleEntity shedule:sheduleEntity){
			sheduleDto.add(mapper.sheduleEntityToDto(shedule));
		}
		
		return sheduleDto;
	}

}
