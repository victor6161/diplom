package com.diplom.kozlov.service;

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
		RouteDto sheduleDto = new RouteDto();
		
		sheduleDto.setPortFrom(portBeanToDto(addBean.getPortFrom()));
		sheduleDto.setPortTo(portBeanToDto(addBean.getPortTo()));
		
		sheduleDto.setNumPoints(addBean.getNumPoints());
		return sheduleDto;
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
		RouteDto sheduleDto = new RouteDto();
		sheduleDto.setId(editorBean.getId());
		sheduleDto.setPortFrom(mapperApplication.portBeanToDto(editorBean.getPortFrom()));
		sheduleDto.setPortTo(mapperApplication.portBeanToDto(editorBean.getPortTo()));
		
		sheduleDto.setNumPoints(editorBean.getNumPoints());
		return sheduleDto;
	}

	public RouteDto rowBeanToDto(RowBean rowBean) {
		RouteDto sheduleDto = new RouteDto();
		sheduleDto.setId(rowBean.getId());
		sheduleDto.setPortFrom(mapperApplication.portBeanToDto(rowBean.getPortFrom()));
		sheduleDto.setPortTo(mapperApplication.portBeanToDto(rowBean.getPortTo()));
	
		sheduleDto.setNumPoints(rowBean.getNumPoints());
		
		return sheduleDto;
	}

	public EditorBean sheduleDtoToEditorBean(RouteDto sheduleDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(sheduleDto.getId());
		editorBean.setPortFrom(mapperApplication.portDtoToBean(sheduleDto.getPortFrom()));
		editorBean.setPortTo(mapperApplication.portDtoToBean(sheduleDto.getPortTo()));
	
		editorBean.setNumPoints(sheduleDto.getNumPoints());

		return editorBean;
	}


	
	
	
}
