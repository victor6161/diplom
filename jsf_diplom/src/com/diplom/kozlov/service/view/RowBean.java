package com.diplom.kozlov.service.view;


import java.time.Period;

import com.diplom.kozlov.application.PortBean;

import lombok.Getter;
import lombok.Setter;

public class RowBean {

	@Setter
	@Getter
	private Integer id;


	@Setter
	@Getter
	private Period period;
	@Setter
	@Getter
	private String title;
	@Setter
	@Getter
	private double distance;
	@Setter
	@Getter
	private PortBean portFrom;
	@Setter
	@Getter
	private PortBean portTo;
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
	private int masut;
	@Setter
	@Getter 
	private int diesel;

	
}
