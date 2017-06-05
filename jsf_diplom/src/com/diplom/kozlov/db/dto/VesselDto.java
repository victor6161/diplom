package com.diplom.kozlov.db.dto;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;

public class VesselDto implements Serializable {
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  private String type;

	  @Setter
	  @Getter
	  private Double fuelConsumption;
	  @Setter
	  @Getter
	  private Double loadCapacity;
	  @Setter
	  @Getter
	  private Double averageSpeed;
	  @Setter
	  @Getter
	  private Double draught;
	  @Setter
	  @Getter
	  private Double length;
	  @Setter
	  @Getter
	  private Double width;
		@Setter
		@Getter
		private int masut;
		@Setter
		@Getter 
		private int diesel;
		

}
