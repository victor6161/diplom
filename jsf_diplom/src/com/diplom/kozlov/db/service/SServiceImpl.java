package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.RouteDao;
import com.diplom.kozlov.db.dao.ServiceDao;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.ServiceDto;
import com.diplom.kozlov.db.dto.UserDto;
import com.diplom.kozlov.entity.RouteEntity;
import com.diplom.kozlov.entity.ServiceEntity;
import com.diplom.kozlov.entity.UserEntity;

public class SServiceImpl {
	Mapper mapper = new Mapper();
	ServiceDao serviceDao = new ServiceDao();
	RouteDao routeDao = new RouteDao();
	private static final Logger LOGGER = Logger.getLogger(SServiceImpl.class);

	public void save(ServiceDto serviceDto) {
		LOGGER.info("save");
		ServiceEntity serviceEntity = mapper.serviceDtoToEntity(serviceDto);
		serviceDao.save(serviceEntity);
	}

	public List<ServiceDto> getList() {
		LOGGER.info("getList");
		List<ServiceEntity> serviceEntity = serviceDao.getList();

		List<ServiceDto> serviceDto = new ArrayList<ServiceDto>();
		serviceEntity.forEach(service -> serviceDto.add(mapper.serviceEntityToDto(service)));
		return serviceDto;
	}

	public void addRoute(RouteDto routeDto, Integer id) {
		LOGGER.info("saveRoute");

		// List<ServiceEntity> serviceEntity =
		// serviceDao.saveRoute(routeEntity,id);

	}

}
