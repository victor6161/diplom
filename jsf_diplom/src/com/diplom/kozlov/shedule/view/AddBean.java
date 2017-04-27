package com.diplom.kozlov.shedule.view;

import java.util.Date;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	public AddBean() {
		portFrom = null;
		portTo = null;
		dateFrom = null;
		dateTo = null;
		vesselBean = null;
	}

	@Override
	public String toString() {
		return "AddBean [portFrom=" + portFrom + ", portTo=" + portTo + ", timeFrom=" + dateFrom + ", timeTo=" + dateTo
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
	private Date dateFrom;
	@Setter
	@Getter
	private Date dateTo;

	@Setter
	@Getter
	private VesselBean vesselBean;

}
