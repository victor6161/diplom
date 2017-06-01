package com.diplom.kozlov.port;


import com.diplom.kozlov.application.CountryBean;
import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.port.view.AddBean;
import com.diplom.kozlov.port.view.EditorBean;
import com.diplom.kozlov.port.view.RowBean;

public class Mapper {
	
	private com.diplom.kozlov.application.Mapper mapperApplication = new com.diplom.kozlov.application.Mapper();

	public RowBean portDtoToRowBean(PortDto portDto) {
		RowBean rowBean = new RowBean();
		rowBean.setId(portDto.getId());
		rowBean.setCountryBean(countryDtoToBean(portDto.getCountryDto()));
		rowBean.setName(portDto.getName());
		rowBean.setLatitude(portDto.getLatitude());
		rowBean.setLongitude(portDto.getLongitude());
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

	public PortDto rowBeanToPortDto(RowBean selectedPort) {
		PortDto portDto = new PortDto();
		portDto.setId(selectedPort.getId());
		portDto.setName(selectedPort.getName());
		portDto.setCountryDto(mapperApplication.countryBeanToDto(selectedPort.getCountryBean()));
		return portDto;
	}
	

	public EditorBean portDtoToEditorBean(PortDto portDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(portDto.getId());
		editorBean.setName(portDto.getName());
		editorBean.setCountryBean(mapperApplication.countryDtoToBean(portDto.getCountryDto()));
		return editorBean;
	}

	public PortDto editorBeanToDto(EditorBean editorBean) {
		PortDto portDto = new PortDto();
		portDto.setId(editorBean.getId());
		portDto.setName(editorBean.getName());
		portDto.setCountryDto(countryBeanToDto(editorBean.getCountryBean()));
		return portDto;
	}
	
	public CountryDto countryBeanToDto(CountryBean countryBean){
		CountryDto countryDto = new CountryDto();
		countryDto.setId(countryBean.getId());
		countryDto.setName(countryBean.getName());
		return countryDto;
	}
	public CountryBean countryDtoToBean(CountryDto countryDto){
		CountryBean countryBean = new CountryBean();
		countryBean.setId(countryDto.getId());
		countryBean.setName(countryDto.getName());
		return countryBean;
	}
	


}
