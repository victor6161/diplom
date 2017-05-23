package com.diplom.kozlov.db.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.MarkerDao;
import com.diplom.kozlov.db.dto.MarkerDto;
import com.diplom.kozlov.entity.MarkerEntity;


public class MarkerServiceImpl  {
	private static final Logger LOGGER = Logger.getLogger( MarkerServiceImpl.class);
	private MarkerDao markerDao = new MarkerDao();

	public void update(List<MarkerDto> markersDto) {
		LOGGER.info("update");
		
		for(MarkerDto markerDto:markersDto){
		
			markerDao.update(new MarkerEntity(markerDto.getId(),markerDto.getLatitude(),markerDto.getLongitude()));
		}
		
		
	}


}
