package com.diplom.kozlov.shedule.view;

import java.util.Date;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	@Override
	public String toString() {
		return "AddBean [portFrom=" + portFrom + ", portTo=" + portTo + ", timeFrom=" + timeFrom + ", timeTo=" + timeTo
				+ ", vesselBean=" + vesselBean + "]";
	}

	@Setter
	@Getter
	private PortBean portFrom;
	@Setter
	@Getter
	private PortBean portTo;
	@Setter
	@Getter
	private Date timeFrom;
	@Setter
	@Getter
	private Date timeTo;
	
	@Setter
	@Getter
	private VesselBean vesselBean;

}
