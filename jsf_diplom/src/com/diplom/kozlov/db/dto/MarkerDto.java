package com.diplom.kozlov.db.dto;

import lombok.Getter;
import lombok.Setter;

public class MarkerDto {
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private double latitude;
	@Setter
	@Getter
	private double longitude;
	@Setter
	@Getter
	private int pathNum;
	
	public MarkerDto(Integer id,double latitude, double longitude, int pathNum) {
		this.id = id ;
		this.latitude = latitude;
		this.longitude = longitude;
		this.pathNum = pathNum;
	}
	public MarkerDto(double latitude, double longitude, int pathNum) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.pathNum = pathNum;
	}
	public MarkerDto(Integer id, double lat, double lng) {
		this.id = id;
		this.latitude = lat;
		this.longitude = lng;
	}

}
