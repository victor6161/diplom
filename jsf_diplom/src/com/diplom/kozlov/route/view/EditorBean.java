package com.diplom.kozlov.route.view;

import java.util.Date;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class EditorBean {
	@Override
	public String toString() {
		return "EditorBean [id=" + id + ", portFrom=" + portFrom + ", portTo=" + portTo + ", dateFrom=" + dateFrom
				+ ", dateTo=" + dateTo + ", vesselBean=" + vesselBean + ", numPoints=" + numPoints + "]";
	}
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
	private Date dateFrom;
	@Setter
	@Getter
	private Date dateTo;

	@Setter
	@Getter
	private VesselBean vesselBean;
	@Setter
	@Getter
	private int numPoints;

}
