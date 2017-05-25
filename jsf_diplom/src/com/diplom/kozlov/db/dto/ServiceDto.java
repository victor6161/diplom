package com.diplom.kozlov.db.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ServiceDto {
	@Override
	public String toString() {
		return "ServiceDto [portFrom=" + portFrom + ", portTo=" + portTo + ", vesselDto=" + vesselDto + ", title="
				+ title + ", routeDto=" + routeDto + "]";
	}
	@Setter
	@Getter
	private PortDto portFrom;
	@Setter
	@Getter
	private PortDto portTo;
	@Setter
	@Getter
	private VesselDto vesselDto;
	@Setter
	@Getter
	private String title;
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private List<RouteDto> routeDto; 
	

}
