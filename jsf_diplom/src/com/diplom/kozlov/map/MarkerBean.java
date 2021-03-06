package com.diplom.kozlov.map;

import lombok.Getter;
import lombok.Setter;

public class MarkerBean {
	@Override
	public String toString() {
		return "MarkerInfo [id=" + polylineId + ", pathNum=" + pathNum + "]";
	}

	@Setter
	@Getter
	private String polylineId;

	public MarkerBean(Integer id,String polylineid, int i) {
		this.id = id;
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
