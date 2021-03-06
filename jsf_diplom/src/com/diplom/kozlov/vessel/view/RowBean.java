package com.diplom.kozlov.vessel.view;

import lombok.Getter;
import lombok.Setter;

public class RowBean {
	
	@Override
	public String toString() {
		return "RowBean [type=" + type + ", loadCapacity=" + loadCapacity + ", averageSpeed=" + averageSpeed
				+ ", fuelConsumtion=" + fuelConsumption + "]";
	}
	@Setter
	@Getter
	private Integer id;
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
	private Double fuelConsumption;
	@Setter
	@Getter
	private double distance;
	@Setter
	@Getter
	private double length;
	@Setter
	@Getter
	private double width;
	@Setter
	@Getter
	private double draught;
	@Setter
	@Getter
	private String firm;
	@Setter
	@Getter
	private String status;
	@Setter
	@Getter
	private String masut;
	@Setter
	@Getter 
	private String diesel;
	
}
