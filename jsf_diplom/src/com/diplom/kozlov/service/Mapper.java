package com.diplom.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.application.RouteBean;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.ServiceDto;
import com.diplom.kozlov.service.view.AddBean;
import com.diplom.kozlov.service.view.RowBean;
import com.diplom.kozlov.service.view.SubRowBean;

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

	public RowBean serviceDtoToRowBean(ServiceDto serviceDto) {
		RowBean rowBean = new RowBean();
		rowBean.setTitle(serviceDto.getTitle());
		rowBean.setVesselId(serviceDto.getVesselDto().getId());
		List<SubRowBean> subRowsBean = new ArrayList<>();
		serviceDto.getRouteDto().forEach(routeDto -> subRowsBean.add(routeDtoToSubRowBean(routeDto)));
		rowBean.setSubRowsBean(subRowsBean);
		return rowBean;
	}

	private SubRowBean routeDtoToSubRowBean(RouteDto routeDto) {

		SubRowBean subRowBean = new SubRowBean();
		subRowBean.setId(routeDto.getId());
		subRowBean.setDistance(routeDto.getDistance());
		return subRowBean;
	}

}
