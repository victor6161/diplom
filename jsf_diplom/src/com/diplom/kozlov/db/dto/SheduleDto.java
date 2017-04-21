package com.diplom.kozlov.db.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SheduleDto {
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
