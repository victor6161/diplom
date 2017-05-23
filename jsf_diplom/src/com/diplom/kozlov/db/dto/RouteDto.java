package com.diplom.kozlov.db.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import lombok.Getter;
import lombok.Setter;

public class RouteDto implements Serializable {
	@Override
	public String toString() {
		return "SheduleDto [id=" + id + ", portFrom=" + portFrom + ", portTo=" + portTo + ", dateTo=" + dateTo
				+ ", dateFrom=" + dateFrom + ", vesselDto=" + vesselDto + "]";
	}
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private PortDto portFrom;
	@Setter
	@Getter
	private PortDto portTo;
	@Setter
	@Getter
	private Date dateTo;
	@Setter
	@Getter
	private Date dateFrom;
	@Setter
	@Getter
	private VesselDto vesselDto;
	@Setter
	@Getter
	private Integer numPoints;
	@Setter
	@Getter
	private List<MarkerDto> markersDto;


	

}
