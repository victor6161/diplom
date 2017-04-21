package com.diplom.kozlov.shedule.view;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class RowBean {
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private String portFrom;
	@Setter
	@Getter
	private String portTo;
	@Setter
	@Getter
	private Date dateTo;
	@Setter
	@Getter
	private Date dateFrom;
	@Setter
	@Getter
	private Integer vesselId;

}
