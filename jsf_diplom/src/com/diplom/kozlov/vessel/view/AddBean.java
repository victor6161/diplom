package com.diplom.kozlov.vessel.view;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	public AddBean(){
		this.type=new String();
		this.loadCapacity=new Integer(0);
		this.averageSpeed=new Integer(0);
		this.fuelConsumtion=new Integer(0);
	}

	@Setter
	@Getter
	private String type;

	@Setter
	@Getter
	private Integer loadCapacity;
	@Setter
	@Getter
	private Integer averageSpeed;
	@Setter
	@Getter
	private Integer fuelConsumtion;

}
