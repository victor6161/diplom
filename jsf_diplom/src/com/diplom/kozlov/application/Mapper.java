package com.diplom.kozlov.application;
import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.user.order.view.CountryBeanOrder;
public class Mapper {
	public CountryBean countryDtoToBean(CountryDto countryDto){
		CountryBean countryBean = new CountryBean();
		countryBean.setId(countryDto.getId());
		countryBean.setName(countryDto.getName());
		countryBean.setPostcode(countryDto.getPostcode());
		countryBean.setTax(countryDto.getTax());
		return countryBean;
		
	}
	public CountryBeanOrder countryBeanToBeanOrder(CountryBean countryBean){
		CountryBeanOrder countryBeanOrder = new CountryBeanOrder();
		countryBeanOrder.setId(countryBean.getId());
		countryBeanOrder.setName(countryBean.getName());
		countryBeanOrder.setPostcode(countryBean.getPostcode());
		countryBeanOrder.setTax(countryBean.getTax());
		return countryBeanOrder;
	}

}
