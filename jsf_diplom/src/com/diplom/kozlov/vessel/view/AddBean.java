package com.diplom.kozlov.vessel.view;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageSpeed == null) ? 0 : averageSpeed.hashCode());
		result = prime * result + ((fuelConsumtion == null) ? 0 : fuelConsumtion.hashCode());
		result = prime * result + ((loadCapacity == null) ? 0 : loadCapacity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddBean other = (AddBean) obj;
		if (averageSpeed == null) {
			if (other.averageSpeed != null)
				return false;
		} else if (!averageSpeed.equals(other.averageSpeed))
			return false;
		if (fuelConsumtion == null) {
			if (other.fuelConsumtion != null)
				return false;
		} else if (!fuelConsumtion.equals(other.fuelConsumtion))
			return false;
		if (loadCapacity == null) {
			if (other.loadCapacity != null)
				return false;
		} else if (!loadCapacity.equals(other.loadCapacity))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public AddBean(){
		this.type=new String();
		this.loadCapacity=new Double(0);
		this.averageSpeed=new Double(0);
		this.fuelConsumtion=new Double(0);
	}

	@Setter
	@Getter
	private String type;

	@Setter
	@Getter
	private Double loadCapacity;
	@Setter
	@Getter
	private Double averageSpeed;
	@Setter
	@Getter
	private Double fuelConsumtion;

}
