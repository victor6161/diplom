package com.diplom.kozlov.db.dto;

import java.io.Serializable;



import lombok.Getter;
import lombok.Setter;

public class CountryDto implements Serializable {
	  public CountryDto() {
		super();
		
	}
	public CountryDto(String country) {
		this.name = country;
	}
	@Override
	public String toString() {
		return "CountryDto [id=" + id + ", name=" + name + ", postcode=" + postcode + ", tax=" + tax + "]";
	}
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
