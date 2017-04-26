package com.diplom.kozlov.db.dto;



import lombok.Getter;
import lombok.Setter;

public class PortDto {
	  @Override
	public String toString() {
		return "PortDto [id=" + id + ", name=" + name + ", countryDto=" + countryDto + "]";
	}
	@Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  private String name;
	  @Setter
	  @Getter
	  private CountryDto countryDto;
}
