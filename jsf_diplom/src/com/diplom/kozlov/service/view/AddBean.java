package com.diplom.kozlov.service.view;

import com.diplom.kozlov.application.RouteBean;
import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class AddBean {

	@Override
	public String toString() {
		return "AddBean [title=" + title + ", routeBean=" + routeBean + ", vesselBean=" + vesselBean + "]";
	}
	@Setter
	@Getter
	private String title;
	@Setter
	@Getter
	private RouteBean routeBean ;
	@Setter
	@Getter
	private VesselBean vesselBean ;

	


}
