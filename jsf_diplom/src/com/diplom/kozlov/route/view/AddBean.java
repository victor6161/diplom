package com.diplom.kozlov.route.view;



import com.diplom.kozlov.application.PortBean;


import lombok.Getter;
import lombok.Setter;

public class AddBean {
	public AddBean() {
		portFrom = null;
		portTo = null;
	
	}


	@Setter
	@Getter
	private PortBean portFrom;
	@Setter
	@Getter
	private PortBean portTo;
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
	private int numPoints;

}
