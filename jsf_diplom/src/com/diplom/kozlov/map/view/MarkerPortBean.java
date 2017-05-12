package com.diplom.kozlov.map.view;

import java.util.List;

import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

public class MarkerPortBean {
	@Setter
	@Getter
	private String portName;
	/*
	 * vessel list
	 */
	@Setter
	@Getter
	private List<VesselBean> vessel;
	

}
