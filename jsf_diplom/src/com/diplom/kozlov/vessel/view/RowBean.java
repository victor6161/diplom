package com.diplom.kozlov.vessel.view;

import lombok.Getter;
import lombok.Setter;

public class RowBean {
	
	@Override
	public String toString() {
		return "RowBean [type=" + type + ", loadCapacity=" + loadCapacity + ", averageSpeed=" + averageSpeed
				+ ", fuelConsumtion=" + fuelConsumtion + "]";
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
