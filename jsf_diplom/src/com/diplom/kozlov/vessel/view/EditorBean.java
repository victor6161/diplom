package com.diplom.kozlov.vessel.view;



import lombok.Getter;
import lombok.Setter;

public class EditorBean {
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private String type;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private double loadCapacity;
	@Setter
	@Getter
	private double averageSpeed;
	@Setter
	@Getter
	private double fuelConsumtion;


}
