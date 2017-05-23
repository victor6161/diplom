package com.diplom.kozlov.service.view;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SubRowBean {

	@Setter
	@Getter
	private String idRoute;
	public SubRowBean(String idRoute, Period period, double cost) {
		super();
		this.idRoute = idRoute;
		this.period = period;
		this.cost = cost;
	}
	@Setter
	@Getter
	private Period period;
	@Setter
	@Getter
	private double cost;

}
