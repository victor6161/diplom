package com.diplom.kozlov.application;
import com.diplom.kozlov.db.dto.CountryDto;


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
		countryDto.setPostcode(countryBean.getPostcode());
		countryDto.setTax(countryBean.getTax());
		return countryDto;
	}
	
	
/*	public CountryBeanOrder countryBeanToBeanOrder(CountryBean countryBean){
		CountryBeanOrder countryBeanOrder = new CountryBeanOrder();
		countryBeanOrder.setId(countryBean.getId());
		countryBeanOrder.setName(countryBean.getName());
		countryBeanOrder.setPostcode(countryBean.getPostcode());
		countryBeanOrder.setTax(countryBean.getTax());
		return countryBeanOrder;
	}*/
/*	public PortBean portDtoToBean(PortDto portDto) {
		PortBean portBean = new PortBean();
		portBean.setId(portDto.getId());
		portBean.setName(portDto.getName());
		portBean.setCountryId(portDto.getCountryDto());
		return portBean;
	}*/
/*	public PortBeanOrder portBeanToBeanOrder(PortBean portBean) {
		PortBeanOrder portBeanOrder = new PortBeanOrder();
		portBeanOrder.setId(portBean.getId());
		portBeanOrder.setName(portBean.getName());
		portBeanOrder.setCountryId(portBean.getCountryId());
		return portBeanOrder;
	}*/

}
