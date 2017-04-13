package com.diplom.kozlov.application;

import lombok.Getter;
import lombok.Setter;

public class CountryBean {
	  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
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
		CountryBean other = (CountryBean) obj;
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
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
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
	  private String postcode;
	  @Setter
	  @Getter
	  private Integer tax;

}
