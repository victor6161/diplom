package com.diplom.kozlov.service.view;

import lombok.Getter;

public class Car {

	public Car(String randomId, String randomBrand, int year, String randomColor, int randomPrice,
			boolean randomSoldState) {
		this.id = randomId;
		this.randomBrand = randomBrand;
		this.year = year;
		this.randomColor = randomColor;
		this.randomPrice = randomPrice;
		this.randomSoldState = randomSoldState;

	}

	@Getter
	String id;
	@Getter
	String randomBrand;
	@Getter
	int year;
	@Getter
	String randomColor;
	@Getter
	int randomPrice;
	@Getter
	boolean randomSoldState;
}
