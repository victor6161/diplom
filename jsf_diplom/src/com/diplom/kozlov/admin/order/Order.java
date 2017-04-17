package com.diplom.kozlov.admin.order;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Order {
	@Setter
	@Getter
	private Integer totalCost;
	@Setter
	@Getter
	private Date dateStart;
	@Setter
	@Getter
	private Date dateEnd;
	@Setter
	@Getter
	private String portFrom;
	@Setter
	@Getter
	private String portTo;
	@Setter
	@Getter
	private String product;
	
}
