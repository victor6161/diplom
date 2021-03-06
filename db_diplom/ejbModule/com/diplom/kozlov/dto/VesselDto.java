package com.diplom.kozlov.dto;

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
	  private String name;
	  @Setter
	  @Getter
	  private Integer fuelConsumption;
	  @Setter
	  @Getter
	  private Integer loadCapacity;
	  @Setter
	  @Getter
	  private Integer averageSpeed;

}
