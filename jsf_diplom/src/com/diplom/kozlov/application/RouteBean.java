package com.diplom.kozlov.application;

import lombok.Getter;
import lombok.Setter;

public class RouteBean {
	@Override
	public String toString() {
		return "RouteBean [id=" + id + ", portTo=" + portTo + ", portFrom=" + portFrom + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portFrom == null) ? 0 : portFrom.hashCode());
		result = prime * result + ((portTo == null) ? 0 : portTo.hashCode());
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
		RouteBean other = (RouteBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (portFrom == null) {
			if (other.portFrom != null)
				return false;
		} else if (!portFrom.equals(other.portFrom))
			return false;
		if (portTo == null) {
			if (other.portTo != null)
				return false;
		} else if (!portTo.equals(other.portTo))
			return false;
		return true;
	}
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private PortBean portTo;
	@Setter
	@Getter
	private PortBean portFrom;

}
