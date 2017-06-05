package com.diplom.kozlov.route.view;

import java.util.Date;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class RowBean {

	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private PortBean portFrom;
	@Setter
	@Getter
	private PortBean portTo;

	@Setter
	@Getter
	private Integer numPoints;
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
	private String title;
}
