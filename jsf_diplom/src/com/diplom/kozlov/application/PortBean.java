package com.diplom.kozlov.application;

import lombok.Getter;
import lombok.Setter;

public class PortBean {
	
	  @Override
	public String toString() {
		return "PortBean [id=" + id + ", countryBean=" + countryBean + ", name=" + name + "]";
	}
	@Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  private CountryBean countryBean;
	  @Setter
	  @Getter
	  private String name;
	  @Setter
	  @Getter
	  private Double latitude;
	  @Setter
	  @Getter
	  private Double longitude;

}
