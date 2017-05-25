package com.diplom.kozlov.service.view;



import java.time.Period;


import lombok.Getter;
import lombok.Setter;

public class SubRowBean {


	@Override
	public String toString() {
		return "SubRowBean [id=" + id + ", period=" + period + ", distance=" + distance + "]";
	}
	@Setter
	@Getter
	private Integer id;

	public SubRowBean() {
	
	}
	@Setter
	@Getter
	private Period period;
	@Setter
	@Getter
	private double distance;

}
