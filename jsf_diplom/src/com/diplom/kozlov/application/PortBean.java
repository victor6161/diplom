package com.diplom.kozlov.application;

import lombok.Getter;
import lombok.Setter;

public class PortBean {
	
	  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryBean == null) ? 0 : countryBean.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
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
		PortBean other = (PortBean) obj;
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
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PortBean [id=" + id + ", countryBean=" + countryBean + ", name=" + name + "]";
	}
	@Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  private CountryBean countryBean;
	  @Setter
	  @Getter
	  private String name;
	  @Setter
	  @Getter
	  private Double latitude;
	  @Setter
	  @Getter
	  private Double longitude;

}
