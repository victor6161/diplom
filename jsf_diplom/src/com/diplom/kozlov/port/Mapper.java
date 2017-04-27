package com.diplom.kozlov.port;


import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.port.view.AddBean;
import com.diplom.kozlov.port.view.RowBean;

public class Mapper {
	
	private com.diplom.kozlov.application.Mapper mapperApplication = new com.diplom.kozlov.application.Mapper();

	public RowBean dtoToRowBean(PortDto port) {
		RowBean rowBean = new RowBean();
		rowBean.setId(port.getId());
		rowBean.setCountry(port.getCountryDto().getName());
		rowBean.setName(port.getName());
		return rowBean;
	}
	
	public PortDto addBeanToDto(AddBean addPort) {
		PortDto portDto = new PortDto();
		portDto.setName(addPort.getName());
		portDto.setCountryDto(mapperApplication.countryBeanToDto(addPort.getCountryBean()));
		portDto.setLatitude(addPort.getLatitude());
		portDto.setLongitude(addPort.getLongitude());
		return portDto;
	}
	
	


}
