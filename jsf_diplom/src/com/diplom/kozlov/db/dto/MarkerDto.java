package com.diplom.kozlov.db.dto;

import lombok.Getter;
import lombok.Setter;

public class MarkerDto {
	@Setter
	@Getter
	private double latitude;
	@Setter
	@Getter
	private double longitude;
	@Setter
	@Getter
	private int pathNum;
	
	public MarkerDto(double latitude, double longitude, int pathNum) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.pathNum = pathNum;
	}

}
