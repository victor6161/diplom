package com.diplom.kozlov.map;

import lombok.Getter;
import lombok.Setter;

public class MarkerInfo {
	@Override
	public String toString() {
		return "MarkerInfo [id=" + polylineId + ", pathNum=" + pathNum + "]";
	}

	@Setter
	@Getter
	private String polylineId;

	public MarkerInfo(String polylineid, int i) {
		this.polylineId = polylineid;
		this.pathNum = i;
	}

	@Setter
	@Getter
	private Integer pathNum;
	@Setter
	@Getter
	private Integer id;

}
