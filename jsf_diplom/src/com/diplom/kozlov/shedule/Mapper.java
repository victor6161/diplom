package com.diplom.kozlov.shedule;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.shedule.view.AddBean;
import com.diplom.kozlov.shedule.view.RowBean;

public class Mapper {
	private com.diplom.kozlov.application.Mapper mapperApplication = new com.diplom.kozlov.application.Mapper();
	public RowBean dtoToRowBean(SheduleDto route) {
		RowBean rowBean = new RowBean();
		rowBean.setId(route.getId());
		rowBean.setPortFrom(route.getPortFrom().getName());
		rowBean.setPortTo(route.getPortTo().getName());
		rowBean.setDateFrom(route.getDateFrom());
		rowBean.setDateTo(route.getDateTo());
		rowBean.setVesselType(route.getVesselDto().getType());
		return rowBean;
	}

	public SheduleDto addBeanToDto(AddBean addBean) {
		SheduleDto sheduleDto = new SheduleDto();
		sheduleDto.setPortFrom(portBeanToDto(addBean.getPortFrom()));
		sheduleDto.setPortTo(portBeanToDto(addBean.getPortTo()));
		sheduleDto.setVesselDto(mapperApplication.vesselBeanToDto(addBean.getVesselBean()));
		return sheduleDto;
	}

	private PortDto portBeanToDto(PortBean portBean) {
		PortDto portDto = new PortDto();
		portDto.setId(portBean.getId());
		portDto.setName(portBean.getName());
		portDto.setCountryDto(mapperApplication.countryBeanToDto(portBean.getCountryBean()));
		return portDto;
	}
	
	
	
}
