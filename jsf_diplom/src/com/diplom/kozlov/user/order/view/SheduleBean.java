package com.diplom.kozlov.user.order.view;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SheduleBean {
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
	
	

}
