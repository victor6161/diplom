package com.diplom.kozlov.service.view;


import java.time.Period;

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
	private String portDep;
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
