package com.diplom.kozlov.port.view;

import com.diplom.kozlov.application.CountryBean;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	@Setter
	@Getter
	private String name;
	
	@Setter
	@Getter
	private CountryBean countryBean;
	@Setter
	@Getter
	private Double latitude;//широта
	@Setter
	@Getter
	private Double longitude;//долгота
	
	
	
	
	

}
