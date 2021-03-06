package com.diplom.kozlov.application;
import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.VesselDto;


public class Mapper {
	public CountryBean countryDtoToBean(CountryDto countryDto){
		CountryBean countryBean = new CountryBean();
		countryBean.setId(countryDto.getId());
		countryBean.setName(countryDto.getName());
		countryBean.setPostcode(countryDto.getPostcode());
		countryBean.setTax(countryDto.getTax());
		return countryBean;
	}
	
	public CountryDto countryBeanToDto(CountryBean countryBean){
		CountryDto countryDto = new CountryDto();
		countryDto.setId(countryBean.getId());
		countryDto.setName(countryBean.getName());
	/*	countryDto.setPostcode(countryBean.getPostcode());
		countryDto.setTax(countryBean.getTax());*/
		return countryDto;
	}

	public PortBean portDtoToBean(PortDto portDto) {
		PortBean portBean = new PortBean();
		portBean.setId(portDto.getId());
		portBean.setName(portDto.getName());
		portBean.setLatitude(portDto.getLatitude());
		portBean.setLongitude(portDto.getLongitude());
		portBean.setCountryBean(countryDtoToBean(portDto.getCountryDto()));
		return portBean;
	}
	public PortDto portBeanToDto(PortBean portBean) {
		PortDto portDto = new PortDto();
		portDto.setId(portBean.getId());
		portDto.setName(portBean.getName());
		portDto.setLatitude(portBean.getLatitude());
		portDto.setLongitude(portBean.getLongitude());
		portDto.setCountryDto(countryBeanToDto(portBean.getCountryBean()));
		return portDto;
	}

	public VesselBean vesselDtoToBean(VesselDto vesselDto) {
		VesselBean vesselBean = new VesselBean();
		vesselBean.setId(vesselDto.getId());
		vesselBean.setType(vesselDto.getType());
		vesselBean.setLength(vesselDto.getLength());
		vesselBean.setWidth(vesselDto.getWidth());
		vesselBean.setMasut(vesselDto.getMasut());
		return vesselBean;
	}

	public VesselDto vesselBeanToDto(VesselBean vesselBean) {
		VesselDto vesselDto =new VesselDto();
		vesselDto.setId(vesselBean.getId());
		vesselDto.setType(vesselBean.getType());
		return vesselDto;
	}

	public RouteBean routeDtoToBean(RouteDto route) {
		RouteBean routeBean = new RouteBean();
		routeBean.setId(route.getId());
		routeBean.setPortFrom(this.portDtoToBean(route.getPortFrom()));
		routeBean.setPortTo(this.portDtoToBean(route.getPortTo()));
		
		return routeBean;
	}

	public RouteDto routeBeanToDto(RouteBean routeBean) {
		RouteDto routeDto = new RouteDto();
		routeDto.setId(routeBean.getId());
		routeDto.setPortFrom(this.portBeanToDto(routeBean.getPortFrom()));
		routeDto.setPortTo(this.portBeanToDto(routeBean.getPortTo()));
		
		return routeDto;
		
	}
	
	


}
