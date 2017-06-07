package com.diplom.kozlov.vessel.view;

import lombok.Getter;
import lombok.Setter;

public class AddBean {

	public AddBean(){
		
	}

	@Setter
	@Getter
	private String type;

	@Setter
	@Getter
	private Double loadCapacity;
	@Setter
	@Getter
	private Double averageSpeed;
	@Setter
	@Getter
	private Double fuelConsumtion;
	@Setter
	@Getter
	private Double width;
	@Setter
	@Getter
	private Double length;
	@Setter
	@Getter
	private Double draught;


}
