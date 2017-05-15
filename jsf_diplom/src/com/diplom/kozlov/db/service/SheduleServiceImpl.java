package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.SheduleDao;
import com.diplom.kozlov.db.dto.MarkerDto;
import com.diplom.kozlov.db.dto.SheduleDto;

import com.diplom.kozlov.entity.SheduleEntity;
import com.diplom.kozlov.port.PortController;


public class SheduleServiceImpl implements SheduleService {
	private static final Logger LOGGER = Logger.getLogger(SheduleServiceImpl.class);
	private SheduleDao sheduleDao = new SheduleDao();
	
	private Mapper mapper = new Mapper();
	@Override
	public void save(SheduleDto sheduleDto) {
	
		List<MarkerDto> markersDto = listPoints(sheduleDto);
		sheduleDto.setMarkersDto(markersDto);
		SheduleEntity sheduleEntity = mapper.sheduleDtoToEntity(sheduleDto);
		sheduleDao.save(sheduleEntity);
	
	}
	
	
	private List<MarkerDto> listPoints(SheduleDto sheduleDto) {
		LOGGER.info("listPoints");
		List<MarkerDto> markerDto = new ArrayList<>();
		double numPoints = (double) sheduleDto.getNumPoints();
		int pathNum = 0;
		double additive = 1 / numPoints;
		
		for (double i = 0; i < 1; i = i + additive) {
			double latitude = sheduleDto.getPortFrom().getLatitude() * (1 - i)
					+ sheduleDto.getPortTo().getLatitude() * i;
			double longitude = sheduleDto.getPortFrom().getLongitude() * (1 - i)
					+ sheduleDto.getPortTo().getLongitude() * i;
			pathNum++;
			
			markerDto.add(new MarkerDto(latitude,longitude,pathNum));
		}
		return markerDto;
	}

	@Override
	public List<SheduleDto> getShedule() {
		LOGGER.info("getShedule");
		List<SheduleEntity> sheduleEntity = sheduleDao.getShedule();
		
		List<SheduleDto> sheduleDto = new ArrayList<>();
		for(SheduleEntity shedule:sheduleEntity){
			sheduleDto.add(mapper.sheduleEntityToDto(shedule));
		}
		
		return sheduleDto;
	}


	public void update(SheduleDto sheduleDto) {
		LOGGER.info("update");
		sheduleDto.setMarkersDto(new ArrayList<>());//потому что в конвертере null pointer 
		SheduleEntity sheduleEntity = mapper.sheduleDtoToEntity(sheduleDto);
		
		sheduleDao.update(sheduleEntity);
		
	}

}
