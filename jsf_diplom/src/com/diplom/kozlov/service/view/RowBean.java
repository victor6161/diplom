package com.diplom.kozlov.service.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class RowBean {
	@Setter
	@Getter
	private String title;
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
