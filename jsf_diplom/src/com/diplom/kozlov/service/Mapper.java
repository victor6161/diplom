package com.diplom.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.application.RouteBean;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.ServiceDto;
import com.diplom.kozlov.service.view.AddBean;
import com.diplom.kozlov.service.view.InfoBean;
import com.diplom.kozlov.service.view.RowBean;

import lombok.Getter;

public class Mapper {
	@Getter
	private com.diplom.kozlov.application.Mapper mapperApplication = new com.diplom.kozlov.application.Mapper();

	public ServiceDto addBeanToDto(AddBean addBean) {
		ServiceDto serviceDto = new ServiceDto();
		serviceDto.setTitle(addBean.getTitle());
		List<RouteDto> routeDto = new ArrayList<>();
		routeDto.add(routeBeanToDto(addBean.getRouteBean()));
		serviceDto.setRouteDto(routeDto);
		serviceDto.setVesselDto(mapperApplication.vesselBeanToDto(addBean.getVesselBean()));
		return serviceDto;
	}

	private RouteDto routeBeanToDto(RouteBean routeBean) {
		RouteDto routeDto = new RouteDto();
		routeDto.setId(routeBean.getId());
		routeDto.setPortFrom(mapperApplication.portBeanToDto(routeBean.getPortFrom()));
		routeDto.setPortTo(mapperApplication.portBeanToDto(routeBean.getPortTo()));
		return routeDto;
	}

	public InfoBean serviceDtoToInfoBean(ServiceDto serviceDto) {
		InfoBean infoBean = new InfoBean();
		infoBean.setId(serviceDto.getId());
		infoBean.setTitle(serviceDto.getTitle());
		infoBean.setVesselBean(mapperApplication.vesselDtoToBean(serviceDto.getVesselDto()));
		double totalDistance = 0;
		for (RouteDto routeDto : serviceDto.getRouteDto()) {
			totalDistance = totalDistance + routeDto.getDistance();
		}

		infoBean.setTotalDistance(totalDistance);
		return infoBean;
	}

	public RowBean routeDtoToRowBean(RouteDto routeDto) {
		RowBean rowBean = new RowBean();
		rowBean.setId(routeDto.getId());
		rowBean.setDistance(routeDto.getDistance());
		rowBean.setDraught(routeDto.getDraught());
		rowBean.setLength(routeDto.getLength());
		rowBean.setWidth(routeDto.getWidth());
		rowBean.setMasut(routeDto.getMasut());
		// rowBean.setPeriod(routeDto);
		return rowBean;
	}

}
