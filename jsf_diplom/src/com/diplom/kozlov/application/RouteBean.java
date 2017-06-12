package com.diplom.kozlov.application;

import lombok.Getter;
import lombok.Setter;

public class RouteBean {

	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private PortBean portTo;
	@Setter
	@Getter
	private PortBean portFrom;
	@Setter
	@Getter
	private double distance;

}
