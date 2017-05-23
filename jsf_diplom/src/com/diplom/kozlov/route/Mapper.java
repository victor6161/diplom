package com.diplom.kozlov.route;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.route.view.AddBean;
import com.diplom.kozlov.route.view.EditorBean;
import com.diplom.kozlov.route.view.RowBean;

public class Mapper {
	private com.diplom.kozlov.application.Mapper mapperApplication = new com.diplom.kozlov.application.Mapper();
	public RowBean dtoToRowBean(RouteDto route) {
		RowBean rowBean = new RowBean();
		rowBean.setId(route.getId());
		rowBean.setPortFrom(mapperApplication.portDtoToBean(route.getPortFrom()));
		rowBean.setPortTo(mapperApplication.portDtoToBean(route.getPortTo()));
	
		rowBean.setNumPoints(route.getNumPoints());
		return rowBean;
	}

	public RouteDto addBeanToDto(AddBean addBean) {
		RouteDto routeDto = new RouteDto();
		routeDto.setDateFrom(addBean.getDateFrom());
		routeDto.setDateTo(addBean.getDateTo());
		routeDto.setPortFrom(portBeanToDto(addBean.getPortFrom()));
		routeDto.setPortTo(portBeanToDto(addBean.getPortTo()));
		routeDto.setVesselDto(mapperApplication.vesselBeanToDto(addBean.getVesselBean()));
		routeDto.setNumPoints(addBean.getNumPoints());
		return routeDto;
	}

	private PortDto portBeanToDto(PortBean portBean) {
		PortDto portDto = new PortDto();
		portDto.setId(portBean.getId());
		portDto.setName(portBean.getName());
		portDto.setLatitude(portBean.getLatitude());
		portDto.setLongitude(portBean.getLongitude());
		portDto.setCountryDto(mapperApplication.countryBeanToDto(portBean.getCountryBean()));
		return portDto;
	}


	public RouteDto editorBeanToDto(EditorBean editorBean) {
		RouteDto routeDto = new RouteDto();
		routeDto.setId(editorBean.getId());
		routeDto.setPortFrom(mapperApplication.portBeanToDto(editorBean.getPortFrom()));
		routeDto.setPortTo(mapperApplication.portBeanToDto(editorBean.getPortTo()));
		routeDto.setVesselDto(mapperApplication.vesselBeanToDto(editorBean.getVesselBean()));
		routeDto.setDateFrom(editorBean.getDateFrom());
		routeDto.setDateTo(editorBean.getDateTo());
		routeDto.setNumPoints(editorBean.getNumPoints());
		return routeDto;
	}

	public RouteDto rowBeanToDto(RowBean rowBean) {
		RouteDto routeDto = new RouteDto();
		routeDto.setId(rowBean.getId());
		routeDto.setPortFrom(mapperApplication.portBeanToDto(rowBean.getPortFrom()));
		routeDto.setPortTo(mapperApplication.portBeanToDto(rowBean.getPortTo()));
		routeDto.setVesselDto(mapperApplication.vesselBeanToDto(rowBean.getVesselBean()));
		routeDto.setDateFrom(rowBean.getDateFrom());
		routeDto.setDateTo(rowBean.getDateTo());
		routeDto.setNumPoints(rowBean.getNumPoints());
		
		return routeDto;
	}

	public EditorBean routeDtoToEditorBean(RouteDto routeDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(routeDto.getId());
		editorBean.setPortFrom(mapperApplication.portDtoToBean(routeDto.getPortFrom()));
		editorBean.setPortTo(mapperApplication.portDtoToBean(routeDto.getPortTo()));
		editorBean.setVesselBean(mapperApplication.vesselDtoToBean(routeDto.getVesselDto()));
		editorBean.setNumPoints(routeDto.getNumPoints());
		editorBean.setDateFrom(routeDto.getDateFrom());
		editorBean.setDateTo(routeDto.getDateTo());
		return editorBean;
	}


	
	
	
}
