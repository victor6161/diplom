package com.diplom.kozlov.map;

import lombok.Getter;
import lombok.Setter;

public class MarkerInfo {
	@Override
	public String toString() {
		return "MarkerInfo [id=" + id + ", pathNum=" + pathNum + "]";
	}

	@Setter
	@Getter
	private String id;

	public MarkerInfo(String id, int i) {
		this.id = id;
		this.pathNum = i;
	}

	@Setter
	@Getter
	private Integer pathNum;

}
