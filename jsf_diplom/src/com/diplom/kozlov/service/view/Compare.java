package com.diplom.kozlov.service.view;

import lombok.Getter;
import lombok.Setter;

public class Compare {
	@Setter
	@Getter
	private String title;
	public Compare(String title, double shipValue, double requiredValue) {
		this.title = title;
		this.shipValue = shipValue;
		this.requiredValue = requiredValue;
		
	}
	@Setter
	@Getter
	private Double shipValue;
	@Setter
	@Getter
	private Double requiredValue;

}
