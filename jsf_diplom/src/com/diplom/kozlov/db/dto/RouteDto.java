package com.diplom.kozlov.db.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import lombok.Getter;
import lombok.Setter;

public class RouteDto implements Serializable {

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
	private Integer numPoints;
	@Setter
	@Getter
	private List<MarkerDto> markersDto;


	

}
