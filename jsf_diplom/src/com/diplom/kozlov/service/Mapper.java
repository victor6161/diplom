package com.diplom.kozlov.service;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.shedule.view.AddBean;
import com.diplom.kozlov.shedule.view.EditorBean;
import com.diplom.kozlov.shedule.view.RowBean;

public class Mapper {
	private com.diplom.kozlov.application.Mapper mapperApplication = new com.diplom.kozlov.application.Mapper();
	public RowBean dtoToRowBean(SheduleDto route) {
		RowBean rowBean = new RowBean();
		rowBean.setId(route.getId());
		rowBean.setPortFrom(mapperApplication.portDtoToBean(route.getPortFrom()));
		rowBean.setPortTo(mapperApplication.portDtoToBean(route.getPortTo()));
		rowBean.setDateFrom(route.getDateFrom());
		rowBean.setDateTo(route.getDateTo());
		rowBean.setVesselBean(mapperApplication.vesselDtoToBean(route.getVesselDto()));
		rowBean.setNumPoints(route.getNumPoints());
		return rowBean;
	}

	public SheduleDto addBeanToDto(AddBean addBean) {
		SheduleDto sheduleDto = new SheduleDto();
		sheduleDto.setDateFrom(addBean.getDateFrom());
		sheduleDto.setDateTo(addBean.getDateTo());
		sheduleDto.setPortFrom(portBeanToDto(addBean.getPortFrom()));
		sheduleDto.setPortTo(portBeanToDto(addBean.getPortTo()));
		sheduleDto.setVesselDto(mapperApplication.vesselBeanToDto(addBean.getVesselBean()));
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


	public SheduleDto editorBeanToDto(EditorBean editorBean) {
		SheduleDto sheduleDto = new SheduleDto();
		sheduleDto.setId(editorBean.getId());
		sheduleDto.setPortFrom(mapperApplication.portBeanToDto(editorBean.getPortFrom()));
		sheduleDto.setPortTo(mapperApplication.portBeanToDto(editorBean.getPortTo()));
		sheduleDto.setVesselDto(mapperApplication.vesselBeanToDto(editorBean.getVesselBean()));
		sheduleDto.setDateFrom(editorBean.getDateFrom());
		sheduleDto.setDateTo(editorBean.getDateTo());
		sheduleDto.setNumPoints(editorBean.getNumPoints());
		return sheduleDto;
	}

	public SheduleDto rowBeanToDto(RowBean rowBean) {
		SheduleDto sheduleDto = new SheduleDto();
		sheduleDto.setId(rowBean.getId());
		sheduleDto.setPortFrom(mapperApplication.portBeanToDto(rowBean.getPortFrom()));
		sheduleDto.setPortTo(mapperApplication.portBeanToDto(rowBean.getPortTo()));
		sheduleDto.setVesselDto(mapperApplication.vesselBeanToDto(rowBean.getVesselBean()));
		sheduleDto.setDateFrom(rowBean.getDateFrom());
		sheduleDto.setDateTo(rowBean.getDateTo());
		sheduleDto.setNumPoints(rowBean.getNumPoints());
		
		return sheduleDto;
	}

	public EditorBean sheduleDtoToEditorBean(SheduleDto sheduleDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(sheduleDto.getId());
		editorBean.setPortFrom(mapperApplication.portDtoToBean(sheduleDto.getPortFrom()));
		editorBean.setPortTo(mapperApplication.portDtoToBean(sheduleDto.getPortTo()));
		editorBean.setVesselBean(mapperApplication.vesselDtoToBean(sheduleDto.getVesselDto()));
		editorBean.setNumPoints(sheduleDto.getNumPoints());
		editorBean.setDateFrom(sheduleDto.getDateFrom());
		editorBean.setDateTo(sheduleDto.getDateTo());
		return editorBean;
	}


	
	
	
}
