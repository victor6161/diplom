package com.diplom.kozlov.service.view;

import java.time.Period;

import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class InfoBean {
	public InfoBean() {
		vesselBean = new VesselBean();
		title = ": ";
	}

	@Setter
	@Getter 
	private Integer id;

	@Setter
	@Getter
	private String title;
	@Setter
	@Getter
	private VesselBean vesselBean;
	@Setter
	@Getter
	private Period totalTime;

	@Setter
	@Getter
	private double totalDistance;

}
