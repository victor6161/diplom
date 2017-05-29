package com.diplom.kozlov.service.view;


import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class RowBean {
	public RowBean() {
		super();
	
	}
	@Setter
	@Getter
	private Integer id;

	@Setter
	@Getter
	private String title;
	@Setter
	@Getter
	private Integer vesselId;
	@Setter
	@Getter
	private Period allTime;
	
	public RowBean(String title) {
		this.title = title;
		subRowsBean = new ArrayList<>();
	}

	@Setter
	@Getter
	private List<SubRowBean> subRowsBean;
	
}
