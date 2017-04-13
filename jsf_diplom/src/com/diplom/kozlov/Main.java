package com.diplom.kozlov;

import com.diplom.kozlov.dao.VesselDao;
import com.diplom.kozlov.entity.VesselEntity;

public class Main {
	public static void main(String[] args) {
		VesselEntity vessel = new VesselEntity();
		vessel.setName("test remote ejb");
		vessel.setType("test remote ejb");
		vessel.setLoadCapacity(14);
		vessel.setAverageSpeed(12);
		vessel.setFuelConsumption(10);


		new VesselDao().save(vessel);;
	}
}
