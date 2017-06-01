package com.diplom.kozlov.port.view;

import com.diplom.kozlov.application.CountryBean;

import lombok.Getter;
import lombok.Setter;

public class RowBean {

	@Override
	public String toString() {
		return "RowBean [id=" + id + ", name=" + name + ", countryBean=" + countryBean + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryBean == null) ? 0 : countryBean.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		RowBean other = (RowBean) obj;
		if (countryBean == null) {
			if (other.countryBean != null)
				return false;
		} else if (!countryBean.equals(other.countryBean))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private CountryBean countryBean;
	@Setter
	@Getter
	private double longitude;
	@Setter
	@Getter
	private double latitude;

}
