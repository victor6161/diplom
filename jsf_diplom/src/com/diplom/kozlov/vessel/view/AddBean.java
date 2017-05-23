package com.diplom.kozlov.vessel.view;

import lombok.Getter;
import lombok.Setter;

public class AddBean {

	public AddBean(){
		this.type=new String();
		this.loadCapacity=new Double(0);
		this.averageSpeed=new Double(0);
		this.fuelConsumtion=new Double(0);
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
