package com.diplom.kozlov.application;
import com.diplom.kozlov.dto.CountryDto;
public class Mapper {
	public CountryBean countryDtoToBean(CountryDto countryDto){
		CountryBean countryBean = new CountryBean();
		countryBean.setId(countryDto.getId());
		countryBean.setName(countryDto.getName());
		countryBean.setPostcode(countryDto.getPostcode());
		countryBean.setTax(countryDto.getTax());
		return countryBean;
		
	}

}
