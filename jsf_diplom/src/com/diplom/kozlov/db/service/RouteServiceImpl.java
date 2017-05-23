package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.RouteDao;
import com.diplom.kozlov.db.dto.MarkerDto;
import com.diplom.kozlov.db.dto.RouteDto;

import com.diplom.kozlov.entity.RouteEntity;
import com.diplom.kozlov.port.PortController;


public class RouteServiceImpl {
	private static final Logger LOGGER = Logger.getLogger(RouteServiceImpl.class);
	private RouteDao routeDao = new RouteDao();
	
	private Mapper mapper = new Mapper();
	
	public void save(RouteDto RouteDto) {
	
		List<MarkerDto> markersDto = listPoints(RouteDto);
		RouteDto.setMarkersDto(markersDto);
		RouteEntity RouteEntity = mapper.routeDtoToEntity(RouteDto);
		routeDao.save(RouteEntity);
	
	}
	
	
	private List<MarkerDto> listPoints(RouteDto RouteDto) {
		LOGGER.info("listPoints");
		List<MarkerDto> markerDto = new ArrayList<>();
		double numPoints = (double) RouteDto.getNumPoints();
		int pathNum = 0;
		double additive = 1 / numPoints;
		
		for (double i = 0; i < 1; i = i + additive) {
			double latitude = RouteDto.getPortFrom().getLatitude() * (1 - i)
					+ RouteDto.getPortTo().getLatitude() * i;
			double longitude = RouteDto.getPortFrom().getLongitude() * (1 - i)
					+ RouteDto.getPortTo().getLongitude() * i;
			pathNum++;
			
			markerDto.add(new MarkerDto(latitude,longitude,pathNum));
		}
		return markerDto;
	}

	

	public List<RouteDto> getRoute() {
		LOGGER.info("getRoute");
		List<RouteEntity> RouteEntity = routeDao.getRoute();
		
		List<RouteDto> RouteDto = new ArrayList<>();
		for(RouteEntity Route:RouteEntity){
			RouteDto.add(mapper.routeEntityToDto(Route));
		}
		
		return RouteDto;
	}


	public void update(RouteDto RouteDto) {
		LOGGER.info("update");
		RouteDto.setMarkersDto(new ArrayList<>());//потому что в конвертере null pointer 
		RouteEntity routeEntity = mapper.routeDtoToEntity(RouteDto);
		
		routeDao.update(routeEntity);
		
	}

}
