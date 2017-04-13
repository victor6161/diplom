package com.diplom.kozlov.dto;

import java.io.Serializable;



import lombok.Getter;
import lombok.Setter;

public class CountryDto implements Serializable {
	  @Setter
	  @Getter
	  private Integer id;
	  
	  @Setter
	  @Getter
	  private String name;
	  @Setter
	  @Getter
	  private String postcode;
	  @Setter
	  @Getter
	  private Integer tax;

}
